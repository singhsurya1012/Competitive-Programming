package medium;

import java.util.Arrays;

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


    public TreeNode buildTree(int[] inorder, int[] postorder) {
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


        root.left = buildTree(Arrays.copyOfRange(inorder, 0, L),
                Arrays.copyOfRange(postorder, 0, L));

        root.right = buildTree(Arrays.copyOfRange(inorder, L + 1, N),
                Arrays.copyOfRange(postorder, L, N - 1));


        return root;

    }
}
