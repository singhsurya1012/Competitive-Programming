package easy;

public class RemoveDuplicatesFromSortedArray {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int removeDuplicates(int[] nums) {

        int writeIndex = 0;
        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            //If value at writeIndex is not equal to value at readIndex
            //Increment the writeIndex Index and copy the value
            if (nums[writeIndex] != nums[readIndex]) {
                writeIndex++;
                nums[writeIndex] = nums[readIndex];
            }
        }
        return writeIndex + 1;
    }
}
