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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preOrderIndex = 0;

        for(int i=0;i<inorder.length;i++){
            inOrderIndexMap.put(inorder[i],i);
        }

        return constructTree(preorder,0,preorder.length-1, 0, inorder.length-1);
    }


    public TreeNode constructTree(int[] preOrder,int ps,int pe, int is, int ie){

        if(is>ie || ps>pe)
            return null;


        int val = preOrder[ps++];
        TreeNode node = new TreeNode(val);

        int i = inOrderIndexMap.get(val);
        int len = i-is;

        node.left = constructTree(preOrder, ps,ps+len-1, is,i-1);
        node.right = constructTree(preOrder, ps+len, pe, i+1, ie);

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
