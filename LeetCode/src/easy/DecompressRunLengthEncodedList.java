package easy;

import java.util.Arrays;

public class DecompressRunLengthEncodedList {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public int[] decompressRLElist(int[] nums) {

        int totalLength = 0;

        //Calculating the total length required for the new array
        for (int i = 0; i < nums.length; i += 2) {
            totalLength += nums[i];
        }

        int[] arr = new int[totalLength];

        int start = 0;
        for (int i = 0; i < nums.length; i += 2) {

            int freq = nums[i];
            int value = nums[i + 1];

            //Updating the new array with value
            for (int j = start; j < start + freq; j++) {
                arr[j] = value;
            }

            start += freq;
        }
        return arr;
    }
}
