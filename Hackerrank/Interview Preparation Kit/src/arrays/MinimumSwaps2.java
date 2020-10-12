package arrays;

public class MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {

        int swaps = 0;

        for (int i = 0; i < arr.length; ) {

            //If the element is already at its current position, move to the next element
            if (arr[i] == i + 1) {
                i++;
            } else {
                //Swap the current element with its correct position and don't move to the next element
                swap(i, arr[i] - 1, arr);
                swaps++;
            }
        }

        return swaps;
    }

    static void swap(int i, int j, int[] arr) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }
}
