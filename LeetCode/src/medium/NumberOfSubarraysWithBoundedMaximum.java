package medium;

public class NumberOfSubarraysWithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int n = nums.length;
        int ans = 0;

        int l = n;
        int r = n;

        for(int i=n-1; i>=0;i--){

            int val = nums[i];
            if(val>right){
                r = i;
                l=i;
                continue;
            }

            if(val<left){
                ans+=r-l;
                continue;
            }

            l = i;
            ans+=r-l;
        }

        return ans;
    }

    public int numSubarrayBoundedMaxDp(int[] nums, int left, int right) {

        int prev = -1;
        int ans = 0;
        int dp = 0;

        for(int i=0; i<nums.length;i++){

            if(nums[i]<left && i>0){
                ans+=dp;
            }else if(nums[i]>right){
                dp=0;
                prev = i;
            }else if(nums[i]>=left && nums[i]<=right){
                dp=i-prev;
                ans+=dp;
            }
        }

        return ans;

    }


    public int numSubarrayBoundedMaxBruteForce(int[] nums, int left, int right) {

        int n = nums.length;
        int ans = 0;

        int max = 0;

        for(int i=0; i<nums.length;i++){
            max = nums[i];
            for(int j=i; j<n;j++){

                max = Math.max(max,nums[j]);
                if(max>=left && max<=right){
                    ans++;
                }

            }
        }

        return ans;
    }
}
