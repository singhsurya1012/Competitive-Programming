package easy;

public class DuplicateZeros {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public void duplicateZeros(int[] arr) {

        int len = arr.length - 1;
        int dup = 0;

        //Count number of 0 but everytime a zero occurs 1 element is removed so we keep decreasing the original length
        for (int i = 0; i <= len - dup; i++) {
            if (arr[i] == 0) {
                //Edge case - when we encounter 0 at the last element. We cant duplicate this so we don't count this.
                //Instead we save this zero at the end since it will be the last element and decrease the original length by 1
                if (i == len - dup) {
                    arr[len] = 0;
                    len--;
                    break;
                }
                dup++;
            }
        }

        int copyTo = len;

        //This is the last index which will get included so we start iterating backwards from here
        int last = len - dup;

        //Copy zero twice and non zero elements once
        for (int i = last; i >= 0; i--) {

            if (arr[i] == 0) {
                arr[copyTo--] = 0;
                arr[copyTo--] = 0;
            } else {
                arr[copyTo--] = arr[i];
            }
        }
    }

}
