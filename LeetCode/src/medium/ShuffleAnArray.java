package medium;

public class ShuffleAnArray {

    class Solution {

        private int[] array;
        private int[] original;

        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            array = original;
            original = original.clone();
            return array;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {

            for (int i = 0; i < array.length; i++) {
                int j = generateNumInRange(i, array.length);
                swap(array, i, j);
            }
            return array;
        }

        public int generateNumInRange(int low, int high) {
            int range = high - low;
            int rand = (int) (Math.random() * range) + low;
            return rand;
        }

        public void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
