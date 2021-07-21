package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new LinkedList<>();

        if (root == null)
            return list;

        boolean inOrder = true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {


            int size = q.size();

            LinkedList<Integer> l = new LinkedList<>();
            for (int i = 1; i <= size; i++) {

                TreeNode n = q.poll();
                if (inOrder) {
                    l.add(n.val);
                } else {
                    l.addFirst(n.val);
                }

                if (n.left != null)
                    q.offer(n.left);

                if (n.right != null)
                    q.offer(n.right);

            }

            list.add(l);
            inOrder = !inOrder;
        }

        return list;
    }
}
