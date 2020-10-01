package easy;

public class MaxConsecutiveOnes {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int ones = 0;
        for (int i : nums) {
            //if currentValue is 1, increment ones counter
            if (i == 1) {
                ones++;
            } else {
                //when we encounter 0, update the max if its bigger than the old max
                maxOnes = Integer.max(maxOnes, ones);
                //reset ones counter to 0
                ones = 0;
            }
        }

        //Check once again since there are changes that the last sequence ended in 1 might be the largest sequence
        return Integer.max(maxOnes, ones);
    }
}
