package easy;

public class RunningSumOf1dArray {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public int[] runningSum(int[] nums) {

        int[] runningSum = new int[nums.length];

        runningSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //running sum is lastSum + current Value
            runningSum[i] = runningSum[i - 1] + nums[i];
        }

        return runningSum;
    }
}
