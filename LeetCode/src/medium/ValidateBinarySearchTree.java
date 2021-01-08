package medium;

import java.util.Stack;

public class ValidateBinarySearchTree {
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


    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isBST(root, null, null);
        //return isBSTRec(root);
        //return isBSTIterative(root);
    }


    //Method which compare every node with its possible range
    public boolean isBST(TreeNode node, TreeNode left, TreeNode right) {

        if (node == null) {
            return true;
        }

        if (left != null && node.val <= left.val) {
            return false;
        }

        if (right != null && node.val >= right.val) {
            return false;
        }


        return isBST(node.left, left, node) && isBST(node.right, node, right);
    }

    //Recursive Approach which uses static prev node and follows Inorder traversal
    public boolean isBSTRec(TreeNode node) {

        if (node == null) {
            return true;
        }

        if (!isBSTRec(node.left)) {
            return false;
        }


        if (prev != null && prev.val >= node.val) {
            return false;
        }

        prev = node;


        return isBSTRec(node.right);
    }


    //Iterative approach using stacks
    public boolean isBSTIterative(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = node;
        TreeNode prev = null;

        while (!stack.isEmpty() || curr != null) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != null && prev.val >= curr.val) {
                return false;
            }

            prev = curr;
            curr = curr.right;
        }

        return true;

    }

}
