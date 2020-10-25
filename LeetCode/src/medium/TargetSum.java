package medium;

import java.util.Arrays;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {

        int[][] memo = new int[nums.length][2001];

        for (int[] r : memo) {
            Arrays.fill(r, Integer.MIN_VALUE);
        }

        return calculateSum(nums, 0, 0, S, memo);

    }

    public int calculateSum(int[] nums, int i, int sum, int S, int[][] memo) {

        if (i == nums.length) {

            if (S == sum)
                return 1;
            else
                return 0;

        } else {

            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }

            int add = calculateSum(nums, i + 1, sum + nums[i], S, memo);
            int sub = calculateSum(nums, i + 1, sum - nums[i], S, memo);

            memo[i][sum + 1000] = add + sub;
            return memo[i][sum + 1000];
        }
    }
}
