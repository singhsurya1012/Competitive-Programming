package medium;

public class HouseRobberII {

    public int rob(int[] nums) {

        int n = nums.length;
        if(n==1)
            return nums[0];



        Integer[] dp1 = new Integer[n];
        int ans = rob(nums,n-1, 0,dp1);
        dp1 = new Integer[n];
        ans = Math.max(ans,rob(nums,n, 1, dp1));
        return ans;


        //Integer[][] dp = new Integer[n][2];
        //return Math.max(rob(nums,n-1, 0, dp) , rob(nums,n, 1, dp));

    }

    private int rob(int[] nums, int len, int pos, Integer[] dp){

        if(pos>=len)
            return 0;

        if(dp[pos]!=null)
            return dp[pos];

        dp[pos] = Math.max(nums[pos] + rob(nums,len, pos+2,dp), rob(nums,len,pos+1, dp));
        return dp[pos];

    }


    private int rob(int[] nums, int len, int pos, Integer[][] dp){

        int n = nums.length;
        if(pos>=len)
            return 0;

        if(dp[pos][n-len]!=null)
            return dp[pos][n-len];

        dp[pos][n-len] = Math.max(nums[pos] + rob(nums,len, pos+2, dp), rob(nums,len,pos+1, dp));
        return dp[pos][n-len];
    }
}
