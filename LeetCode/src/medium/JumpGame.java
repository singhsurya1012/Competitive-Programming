package medium;

public class JumpGame {

    Integer[] dp;
    public boolean canJump(int[] nums) {

        int n = nums.length;
        if(n==1)
            return true;

        if(nums[0]==0)
            return false;


        int max = 0;
        for(int i= 0; i<n; i++) {

            if(max<i)
                return false;

            max = Math.max(i+nums[i], max);
            if(max>=n-1)
                return true;

        }

        return false;

    }


    public boolean canJumpBack(int[] nums) {

        int n = nums.length;
        if(n==1)
            return true;

        if(nums[0]==0)
            return false;


        int last = n-1;
        for(int i= n-2; i>=0; i--) {

            if(nums[i]==0)
                continue;

            if(i+nums[i]>=last){
                last = i;
            }
        }

        return nums[0]>=last;

    }


    public boolean canJumpDp(int[] nums) {

        int n = nums.length;
        if(n==1)
            return true;

        if(nums[0]==0)
            return false;

        dp = new Integer[n];

        return jump(nums, 0 , nums.length-1);
    }


    public boolean jump(int[] nums, int pos, int n){

        if(pos>=n)
            return true;

        if(nums[pos]==0){
            dp[pos] = -1;
            return false;
        }

        if(dp[pos]!=null)
            return dp[pos]==1;

        for(int i=1; i<=nums[pos];i++){

            if(jump(nums, pos+i, n)){
                dp[pos] = 1;
                return true;
            }

        }
        dp[pos]=-1;
        return false;
    }
}
