package medium;

public class MaximumProductOfSplittedBinaryTree {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        long sum;

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

    int M = 1000000007;

    public int maxProduct(TreeNode root) {

        long sum = findTreeSum(root);

        long ans = findMaxProduct(root, sum);
        return (int) (ans % M);

    }

    public long findMaxProduct(TreeNode node, long sum) {

        if (node == null)
            return 0;

        long product = 0;

        long leftSum = node.left != null ? node.left.sum : 0;
        long rightSum = node.right != null ? node.right.sum : 0;
        long subTreeSum = node.val + leftSum + rightSum;

        product = Math.max(product, (sum - subTreeSum) * subTreeSum);

        if (leftSum > rightSum) {
            product = Math.max(product, findMaxProduct(node.left, sum));
        } else {
            product = Math.max(product, findMaxProduct(node.right, sum));
        }

        return product;
    }

    public long findTreeSum(TreeNode node) {

        if (node == null)
            return 0;

        long sum = node.val;

        sum += findTreeSum(node.left);
        sum += findTreeSum(node.right);

        node.sum = sum;

        return sum;
    }
}
