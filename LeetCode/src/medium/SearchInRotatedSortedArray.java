package medium;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        //The array can be considered as two sub sorted sub arrays
        while (l <= r) {

            int m = l + (r - l) / 2;

            if (nums[m] == target) {
                return m;
            }
            //Comparing the mid with the left value we can determine we are in left sorted array or right
            //Left sorted portion of array
            if (nums[m] >= nums[l]) {

                //If target if greater than mid or target is in the right sub array
                //We can discard the left values
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {

                //If target is less than mid or target is in left sub array
                //We can discard the right values
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }

            }
        }

        return -1;

    }
}
