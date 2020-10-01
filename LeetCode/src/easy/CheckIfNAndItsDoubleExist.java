package easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            //Check if we have encountered currentValue*2 or currentValue/2
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
}
