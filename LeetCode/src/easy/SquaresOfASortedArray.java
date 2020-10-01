package easy;

public class SquaresOfASortedArray {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public int[] sortedSquares(int[] A) {

        int [] sqArr = new int[A.length];

        int start = 0;
        int end = A.length -1;

        int i = A.length-1;

        //Squares of array will be decreasing as we move inside from both end
        //So comparing both the ends and saving the highest value at the end of new array
        while(start<=end) {

            if(A[start]*A[start] >= A[end]*A[end]) {
                sqArr[i--] = A[start]*A[start];
                start++;
            }else {
                sqArr[i--] = A[end]*A[end];
                end--;
            }

        }

        return sqArr;
    }
}
