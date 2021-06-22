package medium;

public class LowestCommonAncestorOfABinaryTree {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
  
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;


        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;


    }


    public TreeNode lowestCommonAncestorSlow(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        if (contains(root.left, p)) {

            if (contains(root.right, q))
                return root;
            else
                return lowestCommonAncestor(root.left, p, q);

        } else if (contains(root.left, q)) {

            if (contains(root.right, p))
                return root;
            else
                return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }

    }

    public boolean contains(TreeNode node, TreeNode t) {

        if (node == null)
            return false;

        if (node.val == t.val)
            return true;

        return contains(node.left, t) || contains(node.right, t);
    }
}
