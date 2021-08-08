package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[n];

        int rank = 1;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;

    }
}
