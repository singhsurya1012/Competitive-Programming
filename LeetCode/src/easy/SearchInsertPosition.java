package easy;

public class SearchInsertPosition {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        //Simple binary search
        while (start < end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (nums[end] < target) {
            return end + 1;
        } else {
            return end;
        }

    }
}
