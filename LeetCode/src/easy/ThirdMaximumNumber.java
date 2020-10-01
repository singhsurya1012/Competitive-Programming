package easy;

public class ThirdMaximumNumber {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int thirdMax(int[] nums) {
        //Using Long.MIN_VALUE as Integer.MIN_VALUE can be present in array
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int i : nums) {

            //If current Num is greater than firstMax - set secondMax to firstMax and thirdMax to secondMax
            //else if current num is less than firstMax but greater than secondMax - set thirdMax to secondMax
            //else if current num is less than secondMax but greater than thirdMax - set current num to thirdMax
            if (i > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            } else if (i > secondMax && i < firstMax) {
                thirdMax = secondMax;
                secondMax = i;
            } else if (i > thirdMax && i < secondMax) {
                thirdMax = i;
            }

        }

        //Check if the thirdNum is not default else return the firstMax value
        return (int) (thirdMax != Long.MIN_VALUE ? thirdMax : firstMax);
    }
}
