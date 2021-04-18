package easy;

public class MajorityElement {

    //Boyce-Moore Algorithm
    public int majorityElement(int[] nums) {


        int n = nums.length;
        int max = 0;
        int count = 0;

        for(int i=0; i<n; i++){

            if(count==0){
                max = nums[i];
            }
            if(nums[i]==max){
                count++;
            }else{
                count--;
            }
        }

        count = 0;
        for(int i: nums){
            if(i==max){
                count++;
            }
        }
        return count>n/2?max:0;
    }
}
