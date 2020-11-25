package medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int[] range = {-1, -1};
        if(nums.length==0){
            return range;
        }

        int l = 0;
        int r = nums.length-1;

        //Find the left most occurrence
        while(l<r){

            int m = l + (r-l)/2;

            if(nums[m]<target){
                l = m+1;
            }else {
                r = m;
            }

        }

        if(nums[l]==target){
            range[0] = l;
        }else{
            return range;
        }


        //Find the right most occurrence
        l = 0;
        r = nums.length-1;

        while(l<r){

            int m = l + (r-l)/2;

            if(nums[m]>target){
                r = m-1;
            }else {
                l = m+1;
            }
        }
        if(nums[l]==target){
            range[1]= l;
        }else if(l!=0 && nums[l-1]==target){
            range[1]= l-1;
        }

        return range;
    }
}
