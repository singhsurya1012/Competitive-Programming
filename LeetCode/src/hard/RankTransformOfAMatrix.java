package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class RankTransformOfAMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{-37,-50,-3,44},{-37,-3,13,-32},{47,-42,-3,-40},{-17,-3,-39,24}};
        RankTransformOfAMatrix r = new RankTransformOfAMatrix();
        r.matrixRankTransform(arr);
    }
    public int[][] matrixRankTransform(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] rank = new int[n + m];

        Map<Integer, List<int[]>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new int[]{i,j});
            }
        }

        for (int key : map.keySet()) {

            UF uf = new UF(n + m);
            int[] rank2 = rank.clone();

            for (int[] coord : map.get(key)) {

                int[] res = uf.union(coord[0], coord[1] + n);
                rank2[res[1]] = Math.max(rank2[res[1]], rank2[res[0]]);
            }

            for (int[] coord : map.get(key)) {
                rank[coord[0]] = rank[coord[1] + n] = matrix[coord[0]][coord[1]] = rank2[uf.find(coord[0])] + 1;
            }
        }
        return matrix;
    }

}

class UF {
    int[] parent;

    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        return parent[x] = parent[x] == x ? x : find(parent[x]);
    }

    public int[] union(int x, int y) {
        int px = find(x);
        int py = find(y);
        parent[px] = py;
        return new int[]{px, py};

    }
}
