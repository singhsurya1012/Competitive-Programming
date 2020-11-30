package hard;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {

        int min = 0;
        int max = 1000000000;

        while(min<max){

            int mid = min + (max-min)/2;

            int count = findSubArrays(nums,mid);
            if(count>m){
                min = mid+1;
            }else{
                max = mid;
            }
        }

        return min;

    }

    public int findSubArrays(int[] nums, int target){

        int sum = 0;
        int count = 0;
        for(int i=0; i<nums.length;i++){

            if(nums[i]>target){
                return 100;
            }

            if(sum+nums[i]<=target){
                sum+=nums[i];
            }else{
                sum = nums[i];
                count++;
            }

        }

        count++;

        return count;

    }
}
