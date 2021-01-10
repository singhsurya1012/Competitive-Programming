package easy;

public class BalancedBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Height {
        int h;
    }

    public boolean isBalanced(TreeNode root) {

        //return checkBalanced(root);
        return checkBalancedOptimized(root, new Height());

    }

    private boolean checkBalancedOptimized(TreeNode node, Height height) {

        if (node == null) {
            height.h = 0;
            return true;
        }

        Height lh = new Height();
        Height rh = new Height();

        if (!checkBalancedOptimized(node.left, lh) || !checkBalancedOptimized(node.right, rh)) {
            return false;
        }

        height.h = 1 + Math.max(lh.h, rh.h);

        if (Math.abs(lh.h - rh.h) >= 2) {
            return false;
        }
        return true;
    }

    private boolean checkBalanced(TreeNode node) {

        if (node == null)
            return true;

        if (Math.abs(height(node.left) - height(node.right)) > 1)
            return false;

        return checkBalanced(node.left) && checkBalanced(node.right);


    }


    public int height(TreeNode node) {

        if (node == null)
            return -1;

        return 1 + Math.max(height(node.left), height(node.right));
    }

}
