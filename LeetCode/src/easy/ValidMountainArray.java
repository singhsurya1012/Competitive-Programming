package easy;

public class ValidMountainArray {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public boolean validMountainArray(int[] A) {

        int N = A.length;
        int i=0;

        //Check where peak occurs
        while(i<N-1 && A[i]<A[i+1])
            i++;

        //peak cant be first or last element
        if(i==0 || i==N-1) {
            return false;
        }

        //Check till where array is strictly decreasing
        while(i<N-1 && A[i]> A[i+1])
            i++;

        //return true if the array was strictly decreasing till the end
        return i==N-1;
    }
}
