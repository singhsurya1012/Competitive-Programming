package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    //Time Complexity = O(N^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {

        //Similar to 3 sum Just one extra Loop
        Arrays.sort(nums);
        List<List<Integer>> quad = new ArrayList<>();

        for (int i = 0; i < nums.length - 3 && nums[i] * 4 <= target; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> q = new ArrayList<>(4);
                        q.add(nums[i]);
                        q.add(nums[j]);
                        q.add(nums[left]);
                        q.add(nums[right]);
                        quad.add(q);

                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);

                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right + 1]);

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }


            }

        }

        return quad;

    }


}
