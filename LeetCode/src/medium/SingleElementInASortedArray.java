package medium;

public class SingleElementInASortedArray {

    //Time Complexity : O(logN)
    //Space Complexity : O(1)
    public int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        //Can be done by binary search
        //Note : In any array if middle term index is even means there are even terms on the left side atleast
        while (start < end) {

            int mid = (start + end) / 2;
            boolean even = mid % 2 == 0;

            //If middle term is even, there are even number of terms on left side
            if (even) {
                //If middle term is equal to term on left means left side contains odd element
                //Note we are still taking the equals terms in the new subarray else we would have to move by 2
                if (nums[mid] == nums[mid - 1]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                //If the middle team is odd means left sides have even number of terms
                //If middle term is equal to term on left means right side contains odd element
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }


        }
        return nums[end];
    }
}
