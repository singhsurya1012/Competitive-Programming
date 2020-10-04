package easy;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    //Time Complexity : O(N)
    //Space Complexity : O(101)
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] count = new int[101];

        //Storing the number of times each value occurs. Also this array will be sorted
        //Also maintaining max count so we don't have to iterate over the whole array
        int max = 0;
        for (int i : nums) {
            count[i]++;
            max = Math.max(max, i);
        }

        int smallerNumbers = 0;
        for (int i = 0; i <= max; i++) {

            if (count[i] != 0) {

                int currentCount = count[i];

                //Setting the count as count of numbers which are smaller then the current number
                count[i] = smallerNumbers;
                //adding the current numbers count to the smallerNumbers as they will be smaller than the next number
                smallerNumbers += currentCount;
            }
        }

        //Now the count array has number of elements which are smaller than the index values
        for (int i = 0; i < nums.length; i++) {
            int smallerNumberCount = count[nums[i]];
            nums[i] = smallerNumberCount;
        }

        return nums;
    }
}
