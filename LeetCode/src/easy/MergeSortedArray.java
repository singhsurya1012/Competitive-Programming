package easy;

public class MergeSortedArray {

    //Time Complexity : O(m+n)
    //Space Complexity : O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int writeIndex = m + n - 1;
        //Merge in place in num1
        while (i >= 0 && j >= 0) {

            //Compare last 2 elements of both array
            //Copy the biggest element at the end and decrement pointer of array and write index
            if (nums1[i] >= nums2[j]) {
                nums1[writeIndex] = nums1[i];
                writeIndex--;
                i--;
            } else {
                nums1[writeIndex] = nums2[j];
                writeIndex--;
                j--;
            }
        }

        //Check if we have traversed the second array
        while (j >= 0) {
            nums1[writeIndex] = nums2[j];
            writeIndex--;
            j--;
        }
    }

}
