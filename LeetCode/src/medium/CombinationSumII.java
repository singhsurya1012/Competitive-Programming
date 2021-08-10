package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        combination(candidates, 0, target, new ArrayList<>());
        //backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }


    private void combination(int[] c, int pos, int target, List<Integer> list) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (pos == c.length || target < 0)
            return;

        if (c[pos] <= target) {
            list.add(c[pos]);
            combination(c, pos + 1, target - c[pos], list);
            list.remove(list.size() - 1);
        }

        pos++;
        while (pos < c.length && c[pos - 1] == c[pos]) {
            pos++;
        }

        combination(c, pos, target, list);
    }


    private void backtrack(int[] nums, int pos, int target, List<Integer> list) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || pos == nums.length)
            return;

        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue; // skip duplicates
            list.add(nums[i]);
            backtrack(nums, i+1,target - nums[i], list);
            list.remove(list.size() - 1);
        }
    }
}
