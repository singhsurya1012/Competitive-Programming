package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> l = new ArrayList<>();

            while (size-- > 0) {
                TreeNode curr = queue.poll();
                l.add(curr.val);

                if (curr.left != null) {
                    queue.offer(curr.left);
                }


                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            list.add(l);
        }

        return list;

    }
}
