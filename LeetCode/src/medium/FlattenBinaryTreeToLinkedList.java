package medium;

public class FlattenBinaryTreeToLinkedList {

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
    
    public void flatten(TreeNode root) {
        flattenIterative(root);
    }

    public TreeNode flattenRec(TreeNode root){

        if(root==null)
            return null;;

        TreeNode right = root.right;

        root.right = flattenRec(root.left);
        root.left = null;

        TreeNode curr = root;
        while(curr.right!=null){
            curr=curr.right;
        }
        curr.right = flattenRec(right);
        return root;
    }

    public void flattenIterative(TreeNode node){

        if(node==null)
            return;

        TreeNode curr = node;
        while(curr!=null){

            if(curr.left!=null){

                TreeNode next = curr.left;
                while(next.right!=null){
                    next = next.right;
                }

                next.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
