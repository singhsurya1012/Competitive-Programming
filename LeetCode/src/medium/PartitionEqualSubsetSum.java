package medium;

public class PartitionEqualSubsetSum {

    Boolean[][] dp;
    public boolean canPartition(int[] nums) {

        if(nums.length==1)
            return false;

        int sum = 0;
        for(int i:nums)
            sum+=i;

        if(sum%2!=0)
            return false;
        sum = sum/2;


        dp = new Boolean[nums.length][(sum+1/2) + 1];

        return findSum(nums,0,0,sum);
    }

    public boolean findSum(int[] A, int i, int left, int sum){

        if(i==A.length){
            return left==sum;
        }
        if(left>sum)
            return false;

        if(dp[i][left]!=null)
            return dp[i][left];

        dp[i][left] = findSum(A,i+1,left+A[i],sum) || findSum(A,i+1,left,sum);
        return dp[i][left];
    }
}
