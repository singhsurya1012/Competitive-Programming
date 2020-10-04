package easy;

public class NumberOfGoodPairs {

    //Time Complexity : O(N)
    //Space Complexity : O(101)
    public int numIdenticalPairs(int[] nums) {

        int[] count = new int[101];

        int max = 0;

        //Storing the number of times each value occurs.
        //Also maintaining max count so we don't have to iterate over the whole array
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            max = Math.max(max, nums[i]);
        }

        int goodPairs = 0;

        for (int i = 1; i <= max; i++) {
            //If count is more than 1, number of possible pairs = NC2 = N*N-1/2
            if (count[i] > 1) {
                goodPairs += (count[i] * (count[i] - 1)) / 2;

            }
        }

        return goodPairs;

    }
}
