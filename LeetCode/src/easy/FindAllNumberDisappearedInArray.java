package easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisappearedInArray {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int num = Math.abs(nums[i]);
            //To mark Num is present set the value at its index as negative
            //Make sure to first get the abs value since its possible that its already set to negative once
            nums[num - 1] = -Math.abs(nums[num - 1]);

        }

        List<Integer> l = new ArrayList<>();
        //Any value which is positive means that its index+1 value was not present in original array
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {
                l.add(i + 1);
            }
        }

        return l;

    }
}
