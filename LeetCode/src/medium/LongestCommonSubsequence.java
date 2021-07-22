package medium;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        Integer[][] dp = new Integer[m + 1][n + 1];

        //return longestSubSeq(text1, text2, m,n, dp);
        return longestSubSeqBottomUp1D(text1, text2);
    }

    public int longestSubSeq(String a, String b, int i, int j, Integer[][] dp) {

        if (i <= 0 || j <= 0)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (a.charAt(i - 1) == b.charAt(j - 1))
            dp[i][j] = 1 + longestSubSeq(a, b, i - 1, j - 1, dp);
        else
            dp[i][j] = Math.max(longestSubSeq(a, b, i, j - 1, dp), longestSubSeq(a, b, i - 1, j, dp));

        return dp[i][j];
    }

    public int longestSubSeqBottomUp(String a, String b) {


        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }


    public int longestSubSeqBottomUp1D(String a, String b) {


        int m = a.length();
        int n = b.length();

        if (m > n) {
            return longestSubSeqBottomUp1D(b, a);
        }

        int[] dp = new int[n + 1];

        int prev = 0;

        for (int i = 1; i <= m; i++) {
            prev = dp[0];
            for (int j = 1; j <= n; j++) {

                int temp = dp[j];
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[j] = 1 + prev;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);

                prev = temp;

            }
        }

        return dp[n];
    }
}
