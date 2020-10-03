package medium;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {


    //Time Complexity : O(N)
    //Space Complexity : O(40001)
    public int minIncrementForUniqueWithoutSorting(int[] A) {

        //Since we know the range of values we can create new array with index as value and count as number of times it occurs
        int[] sortedArray = new int[40001];

        //Keeping the max count so we don't have to iterate till the end
        int max = 0;
        for (int i : A) {
            sortedArray[i]++;
            max = Math.max(max, i);
        }

        int moves = 0;

        //iterating till the max value except the max value. For max value we can directly calculate
        for (int i = 0; i < max; i++) {

            //checking if the element occurs more than 1 times, only then we have to increase
            if (sortedArray[i] > 1) {
                //incrementing each element by 1, which will require 1 move each
                //Only 1 element will not be increased as it is unique
                int numberOfElementsToBeIncreased = sortedArray[i] - 1;
                moves += numberOfElementsToBeIncreased;

                //Increasing the next elements count since the current elements are increased by 1
                sortedArray[i + 1] += sortedArray[i] - 1;

                //Setting the current element count to 1
                sortedArray[i] = 1;
            }

        }

        //Directly calculating for max since we cant keep on moving the elements forward
        int numberOfElementsToBeIncreased = sortedArray[max] - 1;


        //Since first element needs to be increased by 1, next by 2,....
        //Calculated using AP of 1,2,3,4...... numberOfElementsToBeIncreased.
        moves += (numberOfElementsToBeIncreased * (numberOfElementsToBeIncreased + 1)) / 2;

        return moves;
    }


    //Time Complexity : O(NlogN)
    //Space Complexity : O(1)
    public int minIncrementForUnique(int[] A) {

        //Sorting the array
        Arrays.sort(A);
        int moves = 0;
        for (int i = 1; i < A.length; i++) {

            //If current value is less the previous value we need to increment it to previous value +1 and calculate the moves required to do that
            if (A[i] <= A[i - 1]) {
                //Incrementing current value to previous value+1 and difference is the number of moves needed
                moves += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return moves;
    }
}
