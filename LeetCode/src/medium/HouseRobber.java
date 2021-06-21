package medium;

public class HouseRobber {

    public int rob(int[] nums) {

        int n = nums.length;
        if(n==1)
            return nums[0];

        //Integer[] dp = new Integer[n];
        //return rob(nums,0, dp);
        return robBottomUpSpaceOptimised(nums);
    }

    public int robBottomUp(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];

        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-2], dp[n-1]);

        for(int i = n-3; i>=0; i--){
            dp[i] = Math.max(nums[i]+dp[i+2], dp[i+1]);
        }

        return dp[0];
    }


    public int robBottomUpSpaceOptimised(int[] nums){
        int n = nums.length;

        int jump = nums[n-1];
        int next =  Math.max(nums[n-2], jump);

        for(int i = n-3; i>=0; i--){
            int curr = Math.max(nums[i]+jump, next);
            jump = next;
            next = curr;
        }

        return next;
    }

    public int rob(int[] nums, int pos, Integer[] dp){

        if(pos>=nums.length)
            return 0;

        if(dp[pos]!=null)
            return dp[pos];

        dp[pos] = Math.max(nums[pos] + rob(nums, pos+2, dp), rob(nums,pos+1, dp));
        return dp[pos];
    }
}
