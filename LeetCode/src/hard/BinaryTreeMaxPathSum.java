package hard;

public class BinaryTreeMaxPathSum {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        int sum = sum(root);
        return Math.max(sum,max);
    }

    public int sum(TreeNode node){

        if(node==null)
            return 0;

        int leftSum = Math.max(0,sum(node.left));
        int rightSum = Math.max(0,sum(node.right));

        max = Math.max(leftSum+rightSum+node.val, max);
        int sum = Math.max(leftSum,rightSum);

        return sum+node.val;
    }
}
