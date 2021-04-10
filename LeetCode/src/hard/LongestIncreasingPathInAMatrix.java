package hard;

public class LongestIncreasingPathInAMatrix {

    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int max = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, traverse(matrix, m, n, dp, i, j));
            }
        }

        return max;
    }


    private int traverse(int[][] matrix, int m, int n, int[][] dp, int i, int j) {

        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int len = 0;

        for (int[] dir : dirs) {

            int x = i + dir[0];
            int y = j + dir[1];

            if (isSafe(m, n, x, y) && matrix[i][j] < matrix[x][y]) {
                len = Math.max(len, traverse(matrix, m, n, dp, x, y));
            }
        }

        dp[i][j] = 1 + len;
        return dp[i][j];

    }


    private boolean isSafe(int m, int n, int i, int j) {

        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}
