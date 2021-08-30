package easy;

import java.util.HashMap;
import java.util.Map;

public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }

        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
        for(int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }

        return row * col;
    }

    public int maxCountTLE(int m, int n, int[][] ops) {

        int[] row = new int[m];
        int[] col = new int[n];

        for(int[] o: ops){
            int x = o[0];
            int y = o[1];

            row[0]++;
            if(x<m)
                row[x]--;

            col[0]++;
            if(y<n)
                col[y]--;
        }

        for(int i=1; i<m;i++){
            row[i] +=row[i-1];
        }

        for(int i=1;i<n;i++){
            col[i] +=col[i-1];
        }

        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){

                int val = Math.min(row[i],col[j]);
                map.put(val, map.getOrDefault(val,0)+1);

                max = Math.max(max,val);
            }
        }

        return map.get(max);
    }
}
