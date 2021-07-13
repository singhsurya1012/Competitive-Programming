package medium;

public class CoinChange {

    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {

        return minCoinsBottomUp(coins,amount);
    }

    public int minCoinsBottomUp(int[] coins, int amount){
        int n = coins.length;
        //min number of coins to make up amount j by using the first i types of coins
        int[][] dp = new int[n+1][amount+1];

        for(int i=1;i<=amount; i++){
            dp[0][i] = 100000;
        }

        for(int i=0;i<=n; i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){

                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }

        return dp[n][amount]>=100000?-1:dp[n][amount];



    }

    public int minCoins(int[] coins, int amount, int pos){

        if(amount==0)
            return 0;

        if(pos>=coins.length)
            return Integer.MAX_VALUE;

        if(dp[pos][amount]!=null)
            return dp[pos][amount];

        int min = Integer.MAX_VALUE;
        int c = 0;
        if(coins[pos]<=amount){
            c = minCoins(coins,amount-coins[pos],pos);
            if(c!=Integer.MAX_VALUE){
                min = Math.min(min, 1+c);
            }
        }

        c = minCoins(coins,amount,pos+1);
        if(c!=Integer.MAX_VALUE)
            min = Math.min(min, c);

        dp[pos][amount] = min;
        return min;
    }
}
