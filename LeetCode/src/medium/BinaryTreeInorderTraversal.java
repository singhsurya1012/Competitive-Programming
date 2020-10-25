package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

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

    List<Integer> l = new ArrayList<>();

    //Simple DFS
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return l;
    }

    public void traverse(TreeNode node) {

        if (node == null) {
            return;
        }

        if (null != node.left) {
            traverse(node.left);
        }

        l.add(node.val);

        if (null != node.right) {
            traverse(node.right);
        }

    }


    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            l.add(curr.val);
            curr = curr.right;
        }
        return l;

    }
}
