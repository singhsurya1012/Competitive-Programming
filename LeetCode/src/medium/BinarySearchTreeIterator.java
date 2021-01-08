package medium;

import java.util.Stack;

public class BinarySearchTreeIterator {

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

    class BSTIterator {

        Stack<TreeNode> stack = null;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            inOrderTraverse(root);
        }

        public int next() {

            TreeNode curr = stack.pop();
            inOrderTraverse(curr.right);
            return curr.val;

        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void inOrderTraverse(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
