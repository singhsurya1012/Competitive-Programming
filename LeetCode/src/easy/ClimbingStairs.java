package easy;

public class ClimbingStairs {

    public int climbStairs(int n) {

        if(n==1){
            return 1;
        }

        int[] dp = new int[n+1];
        return climbDP(n,dp);
        //return climb(0,n,dp);
    }


    public int climb(int start, int n, int[] dp){

        if(start>n){
            return 0;
        }

        if(start==n){
            return 1;
        }

        if(dp[start]>0){
            return dp[start];
        }

        dp[start] = climb(start+1,n,dp) + climb(start+2,n,dp);
        return dp[start];
    }

    public int climbDP(int n, int[] dp){

        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
