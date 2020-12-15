package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {

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

    List<Integer> list = new ArrayList<>();

    //Recursive solution
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return list;

    }


    public void traverse(TreeNode node) {

        if (node == null) {
            return;
        }

        list.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    //Iterative solution
    public List<Integer> preorderTraversalIterative(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                list.add(root.val);
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return list;
    }

}
