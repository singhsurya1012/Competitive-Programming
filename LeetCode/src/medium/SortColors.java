package medium;

public class SortColors {

    public void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int curr = 0;

        while (curr <= right) {

            if (nums[curr] == 0) {
                swap(nums, curr, left);
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } else {
                curr++;
            }
        }
    }


    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
