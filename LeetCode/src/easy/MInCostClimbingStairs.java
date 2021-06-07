package easy;

public class MInCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int dp[] = new int[cost.length];
        return Math.min(minCost(cost,0,dp), minCost(cost,1,dp));

        //return minCostBottomUp(cost);
    }


    public int minCost(int[] cost, int i,int[] dp){

        if(i>=cost.length)
            return 0;

        if(dp[i]!=0)
            return dp[i];

        dp[i] = cost[i] + Math.min(minCost(cost,i+1,dp), minCost(cost,i+2,dp));
        return dp[i];
    }

    public int minCostBottomUp(int[] cost){
        int n = cost.length;

        int[] dp = new int[n];
        dp[n-1] = cost[n-1];
        dp[n-2] = cost[n-2];

        for(int i=n-3; i>=0;i--){
            dp[i] = cost[i] + Math.min(dp[i+1],dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);

    }
}
