package easy;

public class CheckIfArrayIsSortedAndRotated {


    public boolean checkConcise(int[] nums) {
        int k = 0, n = nums.length;
        for (int i = 0; i < n-1; ++i) {
            if (nums[i] > nums[i+1]) {
                k++;
            }
            if (k > 1) {
                return false;
            }
        }

        //check for the last element
        if(nums[n-1]>nums[0])
            k++;

        return k<=1;
    }

    public boolean check(int[] nums) {

        int n = nums.length;
        int smallest = nums[0];

        int i=1;

        for(i=1; i<n; i++){

            if(nums[i]<nums[i-1])
                break;
        }

        if(i==n)
            return true;

        if(nums[i]>nums[0])
            return false;

        i++;

        while(i<n){
            if(nums[i]<nums[i-1] || nums[i]>nums[0])
                return false;
            i++;
        }

        return true;

    }
}
