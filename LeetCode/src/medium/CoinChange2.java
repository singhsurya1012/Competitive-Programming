package medium;

public class CoinChange2 {

    Integer[][] dp;
    public int change(int amount, int[] coins) {

        int n = coins.length;
        dp = new Integer[n][amount+1];

        return count(amount, coins,0, n);
    }

    public int count(int amount, int[] coins, int pos, int n){

        if(amount==0)
            return 1;

        if(pos==n){
            return 0;
        }

        if(dp[pos][amount]!=null)
            return dp[pos][amount];

        int res = 0;

        if(coins[pos]<=amount){
            res+=count(amount-coins[pos], coins, pos, n);
        }

        res+=count(amount,coins,pos+1,n);
        dp[pos][amount]= res;

        return res;
    }


    public int changeBottomUp(int amount, int[] coins) {
        //the number of combinations to make up amount j by using the first i types of coins
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                //dont use the ith coin
                dp[i][j] = dp[i-1][j];
                //Using the ith coin
                dp[i][j] = dp[i][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }


    public int changeBottomUpOptimised(int amount, int[] coins){

        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin : coins){
            for(int i=coin; i<=amount; i++){
                dp[i] +=dp[i-coin];
            }
        }

        return dp[amount];
    }

}
