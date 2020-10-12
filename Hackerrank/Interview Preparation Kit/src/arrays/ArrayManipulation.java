package arrays;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long[] arr = new long[n];

        for(int[] q: queries) {

            //For every query we will increase the start index by k
            //And decrease the index after end by k
            //So while reading we just have to keep adding elements and check the max value
            int start = q[0]-1;
            int end = q[1]-1;
            int k = q[2];

            arr[start] =arr[start]+ k;

            if(end+1<n) {
                arr[end+1] = arr[end+1]-k;
            }
        }

        long max = 0l;
        long curr = 0l;
        for(long i:arr) {
            curr = curr+i;
            max = Long.max(curr,max);
        }

        return max;




    }
}
