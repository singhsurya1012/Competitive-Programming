package hard;

public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;


        if (nums[l] < nums[r]) {
            return nums[l];
        }

        //This is similar to Min in rotated sorted array without duplicates
        //Only extra case is when mid is equal to left
        while (l < r) {

            int m = l + (r - l) / 2;

            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }

            //left sorted array
            if (nums[m] > nums[l]) {
                l = m + 1;
            } else if (nums[m] < nums[l]) {
                r = m;
            } else {
                //Else when mid is equal to left
                //We could simply compare left with its next element and check
                // If there is drop means the next element is smallest
                //else just increment l

                if (nums[l + 1] < nums[l]) {
                    return nums[l + 1];
                } else {
                    l++;
                }

                //Instead we will move from mid to next till we find a bigger element than left
                //Which means we are in the left sorted array or else we are in the right sorted array if we dont find
                //We can also look if there is any drop which will indicate its the smallest element
                /*int n = m + 1;
                boolean left = false;
                while (n <= r) {

                    if (nums[n] > nums[l]) {
                        left = true;
                        break;
                    } else if (nums[n] < nums[m]) {
                        return nums[n];
                    }

                    n++;
                }

                if (left) {
                    l = m;
                } else {
                    r = m;
                }*/
            }
        }

        return nums[l];

    }

}
