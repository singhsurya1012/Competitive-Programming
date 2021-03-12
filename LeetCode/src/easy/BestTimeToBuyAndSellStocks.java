package easy;

import java.util.ArrayList;

public class BestTimeToBuyAndSellStocks {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        int buy = prices[0];
        int sell = prices[0];

        for (int i = 1; i < prices.length; i++) {

            int p = prices[i];

            if (p < buy) {
                buy = p;
                sell = p;
            } else if (p > sell) {
                sell = p;
                maxProfit = Math.max(maxProfit, sell - buy);
            }

        }
        return maxProfit;
    }
}
