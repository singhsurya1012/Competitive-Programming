package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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


    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return constructTree( 0, inorder.length-1, postorder, 0, postorder.length-1);
    }


    public TreeNode constructTree(int is, int ie, int[] postorder, int ps,int pe){

        if(ps>pe || is>ie)
            return null;

        TreeNode node = new TreeNode(postorder[pe]);

        int i = map.get(postorder[pe]);
        int len = i-is;

        node.left = constructTree( is, i-1, postorder, ps, ps+len-1);
        node.right = constructTree( i+1, ie, postorder, ps+len,pe-1);

        return node;
    }


    public TreeNode buildTreeSlow(int[] inorder, int[] postorder) {
        int N = inorder.length;

        if (N == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[N - 1]);

        if (N == 1) {
            return root;
        }

        int L = 0;
        for (int i = 0; i < N; i++) {

            if (inorder[i] == postorder[N - 1]) {
                L = i;
            }
        }


        root.left = buildTreeSlow(Arrays.copyOfRange(inorder, 0, L),
                Arrays.copyOfRange(postorder, 0, L));

        root.right = buildTreeSlow(Arrays.copyOfRange(inorder, L + 1, N),
                Arrays.copyOfRange(postorder, L, N - 1));


        return root;

    }
}
