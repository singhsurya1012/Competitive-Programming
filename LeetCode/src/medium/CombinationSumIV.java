package medium;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {

        Integer[] dp = new Integer[target+1];
        return combinationsDP(nums, target, dp);
    }


    public int combinationBottomUp(int[] nums, int t, Integer[] dp){

        dp[0] = 1;

        for(int i=1; i<=t; i++){

            for(int x:nums){
                if(i>=x){
                    dp[i]+=dp[i-x];
                }
            }

        }


        return dp[t];

    }


    public int combinationsDP(int[] nums, int t, Integer[] dp){

        if(t==0){
            return 1;
        }


        if(dp[t]!=null){
            return dp[t];
        }


        int combinations = 0;

        for(int i: nums){
            if(i<=t){
                combinations+=combinationsDP(nums,t-i,dp);
            }
        }

        dp[t] = combinations;
        return combinations;
    }



    public int combinations(int[] nums, int t){

        if(t==0){
            return 1;
        }

        int combinations = 0;

        for(int i:nums){
            if(i<=t){
                combinations+=combinations(nums,t-i);
            }
        }

        return combinations;
    }
}
