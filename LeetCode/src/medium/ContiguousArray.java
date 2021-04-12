package medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        int n = nums.length;

        int count = 0;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();


        map.put(0, -1);
        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                count -= 1;
            } else {
                count += 1;
            }

            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return max;
    }
}
