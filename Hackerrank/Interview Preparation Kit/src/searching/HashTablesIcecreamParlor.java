package searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTablesIcecreamParlor {

    static void whatFlavors(int[] cost, int money) {

        Map<Integer, List<Integer>> costMap = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {

            int x = cost[i];
            int y = money - x;

            if (costMap.containsKey(y)) {
                System.out.print(costMap.get(y).get(0) + " ");
                System.out.println(i + 1);
                return;
            }

            if (costMap.containsKey(x)) {
                costMap.get(x).add(i + 1);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i + 1);
                costMap.put(x, l);
            }
        }
    }

}
