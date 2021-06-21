package medium;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

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


    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {

        //return robRec(root);
        int[] arr = robOptimised(root);
        return Math.max(arr[0], arr[1]);
    }

    public int[] robOptimised(TreeNode node) {

        if (node == null)
            return new int[]{0, 0};

        int[] left = robOptimised(node.left);
        int[] right = robOptimised(node.right);

        int rob = node.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }


    public int robRec(TreeNode root) {

        if (root == null)
            return 0;

        if (map.containsKey(root))
            return map.get(root);

        int rob = root.val;
        if (root.left != null)
            rob += robRec(root.left.left) + robRec(root.left.right);

        if (root.right != null)
            rob += robRec(root.right.left) + robRec(root.right.right);


        int notRob = robRec(root.left) + robRec(root.right);

        map.put(root, Math.max(rob, notRob));
        return map.get(root);

    }
}
