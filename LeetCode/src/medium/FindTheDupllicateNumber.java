package medium;

public class FindTheDupllicateNumber {

    public int findDuplicate(int[] nums) {

        int tort = nums[0];
        int hare = nums[0];

        do{
            tort = nums[tort];
            hare = nums[nums[hare]];

        }while(tort!=hare);

        tort = nums[0];

        while(tort!=hare){

            tort = nums[tort];
            hare = nums[hare];
        }

        return tort;
    }
}
