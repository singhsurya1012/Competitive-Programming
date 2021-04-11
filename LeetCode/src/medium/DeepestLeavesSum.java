package medium;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

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

    public int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        int sum = 0;
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            sum = 0;
            while (size-- > 0) {

                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return sum;
    }
}
