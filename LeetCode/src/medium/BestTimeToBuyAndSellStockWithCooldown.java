package medium;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {

        int oldBuy = -prices[0];

        int sell_2 = 0;
        int sell_1 = 0;

        for(int i=1;i<prices.length;i++){

            int newSell = Math.max(sell_1,oldBuy+prices[i]);
            int newBuy = Math.max(oldBuy, sell_2-prices[i]);

            oldBuy = newBuy;
            sell_2 = sell_1;
            sell_1 = newSell;
        }


        return sell_1;

        //int[] dp = new int[prices.length];
        //Arrays.fill(dp,-1);

        //return maxProfit(prices, 0,dp);
    }


    public int maxProfit(int[] p, int start,int[] dp){

        if(start>=p.length){
            return 0;
        }

        if(dp[start]!=-1){
            return dp[start];
        }

        int buy = p[start];

        int maxProfit = 0;

        for(int i=start+1; i<p.length;i++){

            if(p[i]<buy){
                buy = p[i];
            }else{
                int profit = (p[i]-buy) + maxProfit(p,i+2,dp);
                maxProfit = Math.max(profit,maxProfit);
            }
        }
        dp[start] = maxProfit;
        return maxProfit;
    }
}
