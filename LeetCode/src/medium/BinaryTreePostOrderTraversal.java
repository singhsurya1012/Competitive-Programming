package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {

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

    LinkedList<Integer> list = new LinkedList<>();

    //Recursive solution
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return list;

    }


    public void traverse(TreeNode node) {

        if (node == null) {
            return;
        }

        traverse(node.left);
        traverse(node.right);
        list.add(node.val);
    }

    //Iterative solution
    public List<Integer> postorderTraversalIterative(TreeNode root) {


        LinkedList<Integer> l = new LinkedList<>();

        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {

            root = stack.pop();
            list.addFirst(root.val);

            if (root.left != null) {
                stack.push(root.left);
            }

            if (root.right != null) {
                stack.push(root.right);
            }
        }

        return list;

    }

}
