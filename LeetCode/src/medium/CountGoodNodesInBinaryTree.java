package medium;

public class CountGoodNodesInBinaryTree {

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

    public int goodNodes(TreeNode root) {

        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode node, int maxVal) {

        if (node == null)
            return 0;

        int goodNodes = 0;
        if (node.val >= maxVal)
            goodNodes++;

        maxVal = Math.max(maxVal, node.val);

        goodNodes += goodNodes(node.left, maxVal);
        goodNodes += goodNodes(node.right, maxVal);

        return goodNodes;
    }
}
