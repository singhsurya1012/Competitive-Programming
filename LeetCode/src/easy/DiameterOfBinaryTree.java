package easy;

public class DiameterOfBinaryTree {

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

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        diameter(root);
        return max;
    }


    public int diameter(TreeNode node){

        if(node==null){
            return -1;
        }

        int dl = diameter(node.left);
        int dr = diameter(node.right);

        int d = dl+dr+2;

        max = Math.max(d,max);
        return Math.max(dl,dr)+1;
    }
}
