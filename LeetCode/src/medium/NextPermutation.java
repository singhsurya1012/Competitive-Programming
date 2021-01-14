package medium;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        for (int i = n - 1; i >= 1; i--) {

            //Find First occurrence from right where left element is less than current;
            if (nums[i] > nums[i - 1]) {

                //Swap it with the smallest possible value greater than current
                int smallestIndex = findNextGreaterThanCurr(nums, i, nums[i - 1]);
                swap(nums, smallestIndex, i - 1);
                //We need to sort the remaining right side but since its already in decreasing order
                //We just need to reverse it
                reverse(nums, i);
                return;
            }
        }

        //If we couldn't find the first occurrence means the array is sorted in decreasing order
        //We just need to reverse the array to find the smallest permutation
        reverse(nums, 0);
        return;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public int findNextGreaterThanCurr(int[] arr, int start, int curr) {

        for (int i = arr.length - 1; i >= start; i--) {
            if (arr[i] > curr) {
                return i;
            }
        }
        return start;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
