package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPreorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer,Integer> inOrderIndexMap = new HashMap<>();
    int preOrderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preOrderIndex = 0;

        for(int i=0;i<inorder.length;i++){
            inOrderIndexMap.put(inorder[i],i);
        }

        return constructTree(preorder,0, inorder.length-1);
    }


    public TreeNode constructTree(int[] preOrder, int left, int right){

        if(left>right)
            return null;


        int val = preOrder[preOrderIndex++];
        TreeNode node = new TreeNode(val);

        node.left = constructTree(preOrder, left,inOrderIndexMap.get(val)-1);
        node.right = constructTree(preOrder,inOrderIndexMap.get(val)+1,right);

        return node;
    }

    public TreeNode buildTreeSlow(int[] preorder, int[] inorder) {
        int N = inorder.length;

        if (N == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        if (N == 1) {
            return root;
        }

        int L = 0;
        for (int i = 0; i < N; i++) {

            if (inorder[i] == preorder[0]) {
                L = i;
            }
        }


        root.left = buildTreeSlow(Arrays.copyOfRange(preorder, 1, L + 1),
                Arrays.copyOfRange(inorder, 0, L));

        root.right = buildTreeSlow(Arrays.copyOfRange(preorder, L + 1, N),
                Arrays.copyOfRange(inorder, L + 1, N));


        return root;

    }
}
