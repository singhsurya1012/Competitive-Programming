package easy;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {

            if (set.contains(i))
                set.remove(i);
            else
                set.add(i);
        }

        return set.iterator().next();

    }

    public int singleNumberBitManipulation(int[] nums) {

        int n = 0;
        for(int i: nums){
            n = n^i;
        }

        return n;
    }
}
