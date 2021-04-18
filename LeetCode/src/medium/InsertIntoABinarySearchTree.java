package medium;


public class InsertIntoABinarySearchTree {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        //return insertRecursive(root,val);
        return insertIterative(root,val);
    }

    private TreeNode insertIterative(TreeNode root, int val) {

        if(root==null){
            return new TreeNode(val);
        }

        TreeNode curr = root;
        TreeNode prev = null;

        while(curr!=null){
            prev = curr;
            if(val<curr.val){
                curr=curr.left;
            }else{
                curr = curr.right;
            }
        }

        if(val < prev.val){
            prev.left = new TreeNode(val);
        }else{
            prev.right = new TreeNode(val);
        }

        return root;

    }


    private TreeNode insertRecursive(TreeNode node, int val) {

        if(node==null){
            return new TreeNode(val);
        }else if(val<node.val){
            node.left = insertIntoBST(node.left,val);
        }else{
            node.right = insertIntoBST(node.right,val);
        }

        return node;
    }


}
