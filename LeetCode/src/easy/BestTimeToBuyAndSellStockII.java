package easy;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {



    public int maxProfitDP(int[] prices) {

        int n = prices.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        dp[n-1] = 0;

        return profit(prices,0, dp);
    }


    public int profit(int[] prices, int index,int[] dp){

        if(index>=prices.length){
            return 0;
        }

        if(dp[index]!=-1){
            return dp[index];
        }

        int buy = prices[index];
        int sell = prices[index];

        int max = 0;

        for(int i=index+1; i<prices.length; i++){

            int p = prices[i];
            if(p<buy){
                buy = p;
                sell = p;
            }else if(p>sell){

                sell = p;

                int currentProfit = sell-buy;
                int futureProfit = currentProfit + profit(prices, i+1, dp);

                max = Math.max(max, futureProfit);
                sell = p;
            }
        }

        max = Math.max(max, sell-buy);
        dp[index] = max;
        return max;

    }
}
