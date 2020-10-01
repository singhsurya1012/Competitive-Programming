package easy;

public class FindPivotIndex {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int pivotIndex(int[] nums) {

        int sum = 0;
        for(int i: nums) {
            sum +=i;
        }



        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i<nums.length;i++) {
            //calculating right sum
            rightSum  = sum - leftSum - nums[i];

            if(leftSum==rightSum) {
                return i;
            }
            //adding current value to left sum as we go from left to right
            leftSum+=nums[i];
        }

        return -1;

    }
}
