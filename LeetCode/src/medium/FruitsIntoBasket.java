package medium;

import java.util.HashMap;

public class FruitsIntoBasket {

    public int totalFruit(int[] tree) {

        EasyMap count = new EasyMap();
        int start = 0;
        int n = tree.length;
        int ans = 0;

        for (int end = 0; end < n; end++) {

            count.add(tree[end], 1);

            while (count.size() >= 3) {

                count.add(tree[start], -1);

                if (count.get(tree[start]) == 0) {
                    count.remove(tree[start]);
                }
                start++;
            }

            ans = Math.max(ans, end - start + 1);
        }

        return ans;

    }
}

class EasyMap extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}