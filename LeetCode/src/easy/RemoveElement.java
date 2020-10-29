package easy;

public class RemoveElement {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int removeElement(int[] nums, int val) {

        //Using writeIndex index to write to array
        //This will increment if writeIndex value is not equal to the target
        int writeIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            //If current value is not equal to target
            if (nums[i] != val) {

                //If both currentIndex and write index is not equal
                //Copy the value to writeIndex and increment writeIndex
                if (i != writeIndex) {
                    nums[writeIndex] = nums[i];
                }
                writeIndex++;
            }
        }

        return writeIndex;

    }

}
