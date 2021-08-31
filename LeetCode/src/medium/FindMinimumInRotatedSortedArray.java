package medium;

public class FindMinimumInRotatedSortedArray {

    public int findMinClean(int[] nums) {

        //Check if the array is sorted
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;


        while(l<r){

            int m = (l+r)/2;

            if(nums[m]<nums[r]){
                r = m;
            }else{
                l = m+1;
            }
        }
        return nums[l];

    }

    public int findMin(int[] nums) {

        //Check if the array is sorted
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;

        //Rotated array has a single drop
        while (l < r) {

            int m = l + (r - l) / 2;

            //check if the mid is thr drop
            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }

            //Check if we are in left sorted aaray
            if (nums[m] > nums[l]) {
                l = m + 1;
            } else {
                r = m;
            }

        }

        return nums[l];

    }
}
