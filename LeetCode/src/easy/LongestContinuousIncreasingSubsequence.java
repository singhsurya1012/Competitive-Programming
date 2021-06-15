package easy;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {

        int ans = 1;
        int curr = 1;

        for(int i=1; i<nums.length;i++){

            if(nums[i]>nums[i-1]){
                curr++;
            }else{
                ans = Math.max(ans,curr);
                curr=1;
            }
        }


        return Math.max(ans,curr);
    }
}
