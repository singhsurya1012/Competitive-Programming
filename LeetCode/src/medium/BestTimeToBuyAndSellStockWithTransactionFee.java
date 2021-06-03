package medium;

public class BestTimeToBuyAndSellStockWithTransactionFee {


    /**
     * O --> In sold sate at the end of ith day
     * 1 --> In bought state at the end of ith day
     *
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
     * T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])
     *
     * */
    public int maxProfit(int[] prices, int fee) {


        int oldBuy = -prices[0];
        int oldSell = 0;

        for(int i=1;i<prices.length;i++){

            int newSell = Math.max(oldSell,oldBuy+prices[i]-fee);
            int newBuy = Math.max(oldBuy, oldSell-prices[i]);

            oldBuy = newBuy;
            oldSell = newSell;

        }

        return oldSell;

        //int[] dp = new int[prices.length];
        //Arrays.fill(dp,-1);

        //return maxProfit(prices,fee, 0,dp);

    }


    public int maxProfit(int[] p,int fee, int start,int[] dp){

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
                int profit = (p[i]-buy -fee) + maxProfit(p,fee,i+1,dp);
                maxProfit = Math.max(profit,maxProfit);
            }
        }
        dp[start] = maxProfit;
        return maxProfit;
    }
}
