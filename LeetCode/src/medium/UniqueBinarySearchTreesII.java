package medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> generateTrees(int n) {

        List<TreeNode>[] res = new List[n + 1];
        res[0] = new ArrayList();
        if (n == 0) return res[0];
        res[0].add(null);
        res[1] = new ArrayList();
        res[1].add(new TreeNode(1));

        for (int i = 2; i <= n; i++) {
            res[i] = new ArrayList<>();

            for (int j = 0; j <= i - 1; j++) {
                int k = i - 1 - j;

                for (TreeNode left : res[j]) {
                    for (TreeNode right : res[k]) {

                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        res[i].add(root);
                    }
                }

            }
        }

        return res[n];

    }


    public TreeNode clone(TreeNode node, int offset) {
        if (node == null) return null;
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = clone(node.left, offset);
        newNode.right = clone(node.right, offset);
        return newNode;
    }

    public List<TreeNode> generateTreesRec(int n) {

        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return generateTrees(1, n, dp);
    }

    public List<TreeNode> generateTrees(int start, int end, List<TreeNode>[][] dp) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> left = generateTrees(start, i - 1, dp);
            List<TreeNode> right = generateTrees(i + 1, end, dp);

            for (TreeNode l : left) {
                for (TreeNode r : right) {

                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;

                    result.add(root);
                }
            }

        }
        dp[start][end] = result;
        return result;

    }
}
