package medium;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {

    public int arrayNesting(int[] nums) {

        int n = nums.length;

        Set<Integer> seen = new HashSet<>();

        int max = 0;
        int len = 0;

        for(int i=0;i<n;i++){

            if(seen.contains(nums[i]))
                continue;

            int curr = nums[i];
            while(!seen.contains(curr)){

                seen.add(curr);
                len++;
                curr = nums[curr];
            }

            max = Math.max(len,max);
            len = 0;
        }

        return max;
    }
}
