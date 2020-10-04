package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    //Time Complexity : O(N^2)
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int target = 0;
        //Checking only for first value less than equal to zero
        //since for positive number array is sorted so all triplets will be greater than zero
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {

            //Check if new element is same as previous element, we can skip it since its already counted
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {

                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //If after match the next element is also same we continue moving forward till we find a new element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    //Same thing we do on the right side
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    //now we know the next element on both side is new so we move the pointers
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return triplets;
    }
}
