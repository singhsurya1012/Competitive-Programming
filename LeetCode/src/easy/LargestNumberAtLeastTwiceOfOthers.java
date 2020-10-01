package easy;

public class LargestNumberAtLeastTwiceOfOthers {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int dominantIndex(int[] nums) {

        //setting Actual Max and any future expected max
        int max = nums[0];
        int expectedMax = nums[0];

        int index = 0;

        for( int i = 1; i<nums.length;i++) {

            //if current value is greater than our max
            if(nums[i]>max) {

                //but if current value is less than 2*currentMax
                //means we expect currentMax*2 in future
                if(max*2>nums[i]) {
                    expectedMax = max*2;
                    max = nums[i];
                }else {
                    max = nums[i];
                    expectedMax = max;
                }

                index = i;


            }else {

                //if 2*currentValue is greater than currentMex, we expect a number 2*currentValue in future
                if(nums[i]*2>max) {
                    expectedMax = nums[i]*2;
                }

            }
        }

        if(expectedMax==max) {
            return index;
        }

        return -1;

    }
}
