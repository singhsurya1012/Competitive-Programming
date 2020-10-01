package easy;

public class ReplaceElementsWithGreatestElementOnRightSide {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int[] replaceElements(int[] arr) {

        int N = arr.length;
        int greatestElement = arr[N-1];
        arr[N-1] = -1;

        //Iterating from the right side, keep track of max element
        //Replace the current element with max
        //Update the max if old max is less than the original current Value
        for(int i= N-2; i>=0;i--) {

            int currentVal = arr[i];
            arr[i] = greatestElement;
            greatestElement = Integer.max(greatestElement, currentVal);
        }

        return arr;

    }

}
