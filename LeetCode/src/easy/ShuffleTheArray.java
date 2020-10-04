package easy;

public class ShuffleTheArray {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public int[] shuffle(int[] nums, int n) {

        int[] arr = new int[nums.length];
        //Simple 2 pointer to move one pointer from start and other pointer from the middle of array
        for (int i = 0; i < n; i++) {

            arr[2 * i] = nums[i];
            arr[2 * i + 1] = nums[i + n];
        }

        return arr;


    }
}
