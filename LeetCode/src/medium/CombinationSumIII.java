package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        combination(1, 9, k, n, new ArrayList<Integer>());
        return result;
    }

    public void combination(int start, int end, int k, int target, List<Integer> list) {

        if (k == 1) {
            if (target >= start && target <= end) {
                list.add(target);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        for (int i = start; i <= end; i++) {

            if (i > target)
                break;

            list.add(i);
            combination(i + 1, end, k - 1, target - i, list);
            list.remove(list.size() - 1);
        }
    }
}
