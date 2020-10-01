package easy;

public class RemoveElement {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int removeElement(int[] nums, int val) {
        int valOccurrence = 0;

        //Counting all the occurrence of val
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {
                valOccurrence++;
            }
        }

        //new Array length removing all occurrence of val
        int newLength = nums.length - valOccurrence;

        if (0 != valOccurrence) {

            int writeIndex = 0;
            for (int readIndex = 0; readIndex < nums.length && writeIndex < newLength; readIndex++) {
                //write the value if current value is not equal to val
                if (nums[readIndex] != val) {
                    nums[writeIndex] = nums[readIndex];
                    writeIndex++;
                }
            }
        }

        return newLength;

    }
}
