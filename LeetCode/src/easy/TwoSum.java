package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public int[] twoSum(int[] nums, int target) {
        //Set can be used which is internally a hashmap anyway
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        //anyOldValue + currentValue = target
        // so if target - currentValue is present in map then the condition satisfies
        //else we add currentValue in map
        //Time complexity = O(N) and SpaceComplexity = O(N)

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
