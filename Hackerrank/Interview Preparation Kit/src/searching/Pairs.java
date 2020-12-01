package searching;

import java.util.HashMap;
import java.util.Map;

public class Pairs {

    static int pairs(int k, int[] arr) {

        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {

            pairs += map.getOrDefault(i - k, 0);
            pairs += map.getOrDefault(i + k, 0);

            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return pairs;
    }

}
