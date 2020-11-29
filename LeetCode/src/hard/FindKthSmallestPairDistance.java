package hard;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        //Sum can be between (lo,hi)
        int lo = 0;
        int hi = nums[nums.length-1] - nums[0];


        //Binary search on the possible values
        while(lo<hi){

            int m = lo + (hi-lo)/2;

            int right = 0;
            int count =  0;

            //Calculate pairs with distance less than equal to m
            for(int left = 0; left<nums.length; left++){
                right = left+1;

                while(right<nums.length && nums[right]-nums[left]<=m){
                    right++;
                }

                count +=right-1-left;
            }

            //if number of pairs is less than k then we need to increase our value so me move lo to m+1
            //If number of pair is greater or equal we need to decrease our value so move hi to m
            //We still need to include m since it can be answer
            //We cant directly check if count =k and return since there can be even smaller value for count=k
            if(count<k){
                lo=m+1;
            }else{
                hi=m;
            }

        }

        return lo;
    }

}
