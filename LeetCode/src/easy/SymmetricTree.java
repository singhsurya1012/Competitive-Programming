package easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

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


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode a, TreeNode b) {

        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }
        return symmetric(a.left, b.right) && symmetric(a.right, b.left);
    }

    //Iterative Approach
    public boolean isSymmetricIterative(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {

            TreeNode a = q.poll();
            TreeNode b = q.poll();

            if (a == null && b == null) {
                continue;
            }
            if (a == null || b == null) {
                return false;
            }

            if (a.val != b.val) {
                return false;
            }

            q.offer(a.left);
            q.offer(b.right);
            q.offer(a.right);
            q.offer(b.left);
        }

        return true;
    }
}
