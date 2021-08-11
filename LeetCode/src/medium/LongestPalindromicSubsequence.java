package medium;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        Integer[][] dp = new Integer[n][n];


        //StringBuilder reverse = new StringBuilder(s);
        //reverse.reverse();
        //return longestCommonSubsequence(s,reverse.toString());

        //return longestPalindromeSubseq(s,0,n-1,dp);
        return longestPalindromeSubseqBottomUp(s);
    }


    public int longestPalindromeSubseqBottomUp(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public int longestPalindromeSubseq(String s, int i, int j, Integer[][] dp) {

        if (i > j)
            return 0;

        if (i == j)
            return 1;

        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j))
            dp[i][j] = 2 + longestPalindromeSubseq(s, i + 1, j - 1, dp);
        else
            dp[i][j] = Math.max(longestPalindromeSubseq(s, i + 1, j, dp),
                    longestPalindromeSubseq(s, i, j - 1, dp));

        return dp[i][j];
    }


    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        Integer[][] dp = new Integer[m + 1][n + 1];

        //return longestSubSeq(text1, text2, m,n, dp);
        return longestSubSeqBottomUp(text1, text2);
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
}
