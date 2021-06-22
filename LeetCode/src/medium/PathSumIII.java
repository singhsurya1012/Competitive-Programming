package medium;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

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

    public int pathSum(TreeNode root, int targetSum) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return pathSumMap(root, 0, targetSum, map);
    }

    private int pathSumMap(TreeNode node, int pre, int t, Map<Integer, Integer> map) {

        if (node == null)
            return 0;

        pre += node.val;

        int ans = 0;
        if (map.containsKey(pre - t)) {
            ans += map.get(pre - t);
        }

        map.put(pre, map.getOrDefault(pre, 0) + 1);

        ans += pathSumMap(node.left, pre, t, map) + pathSumMap(node.right, pre, t, map);
        map.put(pre, map.getOrDefault(pre, 0) - 1);

        return ans;

    }

    public int pathSumRec(TreeNode root, int targetSum) {

        if (root == null)
            return 0;

        return pathSumFrom(root, targetSum) + pathSumRec(root.left, targetSum) + pathSumRec(root.right, targetSum);
    }

    public int pathSumFrom(TreeNode node, int t) {

        if (node == null)
            return 0;

        int ans = 0;
        if (node.val == t)
            ans++;

        ans += pathSumFrom(node.left, t - node.val) + pathSumFrom(node.right, t - node.val);
        return ans;
    }
}
