package easy;

public class SortArrayByParity {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int[] sortArrayByParity(int[] A) {
        int writeIndex = 0;

        for (int readIndex = 0; readIndex < A.length; readIndex++) {

            //If current Value is even, move it to the front by swapping
            if (A[readIndex] % 2 == 0) {
                int currVal = A[writeIndex];
                A[writeIndex] = A[readIndex];
                A[readIndex] = currVal;

                writeIndex++;
            }
        }

        return A;

    }
}
