package medium;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {

        int n =nums.length;
        if(n<=2)
            return false;

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for(int i=0 ; i<n; i++){
            if(nums[i]<=a){
                a = nums[i];
            }else if(nums[i]<=b){
                b = nums[i];
            }else {
                return true;
            }
        }
        return false;
    }
}
