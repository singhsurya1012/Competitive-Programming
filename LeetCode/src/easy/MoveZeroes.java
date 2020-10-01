package easy;

public class MoveZeroes {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public void moveZeroes(int[] nums) {
        int writeIndex = 0;

        for(int readIndex =0; readIndex<nums.length; readIndex++) {

            //If the readIndex value is not zero swap it with the current value
            if(nums[readIndex]!=0) {
                int writeIndexValue = nums[writeIndex];
                nums[writeIndex] = nums[readIndex];
                nums[readIndex] = writeIndexValue;
                writeIndex++;
            }
        }

    }

}
