package easy;

public class SearchInABinarySearchTree {

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


    public TreeNode searchBST(TreeNode root, int val) {

        //return searchRecursive(root,val);
        return searchIterative(root, val);
    }

    private TreeNode searchRecursive(TreeNode node, int val) {

        if (node == null) {
            return null;
        }

        if (node.val == val) {
            return node;
        } else if (val < node.val) {
            return searchBST(node.left, val);
        } else {
            return searchBST(node.right, val);
        }
    }

    private TreeNode searchIterative(TreeNode node, int val) {

        if (node == null) {
            return null;
        }

        TreeNode curr = node;
        while (curr != null) {
            if (curr.val == val) {
                return curr;
            } else if (val < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return curr;
    }
}
