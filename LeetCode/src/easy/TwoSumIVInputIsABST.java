package easy;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsABST {

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

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }

    public boolean findTarget(TreeNode node, int k, Set<Integer> set) {

        if (node == null)
            return false;

        if (set.contains(k - node.val))
            return true;

        set.add(node.val);

        return findTarget(node.left, k, set) || findTarget(node.right, k, set);
    }
}
