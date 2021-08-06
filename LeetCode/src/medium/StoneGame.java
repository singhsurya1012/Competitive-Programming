package medium;

public class StoneGame {

    Integer[][] dp;

    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }

        dp = new Integer[n][n];

        //int stones = pickStoneDp(piles,0,n-1);
        //int stones = pickStoneBottomUp(piles);
        int stones = pickStone(piles);
        return stones > 0;

        //return pickStoneRec(piles,0,n-1, true);
    }


    public int pickStone(int[] piles) {

        int n = piles.length;
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            dp[i][i] = new int[]{piles[i], 0};
        }

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                int pickLeftScore = piles[i] + dp[i + 1][j][1];
                int pickRightScore = piles[j] + dp[i][j - 1][1];

                if (pickLeftScore > pickRightScore) {
                    dp[i][j][0] = pickLeftScore;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = pickRightScore;
                    dp[i][j][1] = dp[i][j - 1][0];
                }

            }
        }

        return dp[0][n - 1][0] - dp[0][n - 1][1];

    }


    public int pickStoneBottomUp(int[] piles) {

        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = piles[i];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }

    public int pickStoneDp(int[] piles, int start, int end) {

        if (start > end)
            return 0;

        if (dp[start][end] != null)
            return dp[start][end];

        int leftPick = piles[start] - pickStoneDp(piles, start + 1, end);
        int rightPick = piles[end] - pickStoneDp(piles, start, end - 1);

        dp[start][end] = Math.max(leftPick, rightPick);
        return dp[start][end];

    }

    public boolean pickStone(int[] piles, int start, int end, int alex, int lee, boolean alexTurn) {


        if (start > end)
            return alex > lee;


        if (alexTurn) {
            return pickStone(piles, start + 1, end, alex + piles[start], lee, !alexTurn) ||
                    pickStone(piles, start, end - 1, alex + piles[end], lee, !alexTurn);
        } else {
            return pickStone(piles, start + 1, end, alex, lee + piles[start], !alexTurn) ||
                    pickStone(piles, start, end - 1, alex, lee + piles[end], !alexTurn);
        }

    }
}
