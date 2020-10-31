package medium;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        k = k%nums.length;
        int count = 0;

        //In each iteration move the current element to its correct position
        //Store the removed element and move it to correct position in the next attempt
        //Continue till we have moved all elements in array
        for(int start =0; count<nums.length; start++){

            int currIndex = start;
            int prevVal = nums[start];

            do{
                int nextIndex = (currIndex+k)%nums.length;
                int nextVal = nums[nextIndex];
                nums[nextIndex] = prevVal;
                currIndex = nextIndex;
                prevVal = nextVal;

                count++;

            }while(start!=currIndex);
        }
    }

}
