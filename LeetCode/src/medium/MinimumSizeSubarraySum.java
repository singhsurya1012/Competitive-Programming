package medium;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        int minLength = nums.length + 1;

        if (nums.length == 0) {
            return 0;
        }

        if (nums[0] >= s) {
            return 1;
        }

        int first = 0;
        int sum = 0;

        //Using two pointer find till the sum is greater or equal to target
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            //If greater or equal to target calculate length
            //Keep removing the first element till the sum is less than target
            while (sum >= s) {
                int len = i - first + 1;
                minLength = Integer.min(minLength, len);

                sum -= nums[first];
                first++;
            }

        }

        if (minLength == nums.length + 1) {
            return 0;
        }

        return minLength;

    }
}
