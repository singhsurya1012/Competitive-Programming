package medium;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        //Sorting the array
        Arrays.sort(nums);

        //Setting the Closest target to the first combinations by default
        int closestTarget = nums[0] + nums[1] + nums[2];

        //Fixing the first Element
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                //Since the array is sorted looking at the sum we know where we want to move
                int sum = nums[i] + nums[left] + nums[right];

                //If sum matches target we can return directly
                if (sum == target) {
                    return sum;
                }

                //Else check if sum is closest to the target than the old closest target;
                if (Math.abs(sum - target) < Math.abs(closestTarget - target)) {
                    closestTarget = sum;
                }

                //If the sum is less than target we move the left index
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return closestTarget;

    }
}
