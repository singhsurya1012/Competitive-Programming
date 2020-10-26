package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {


    //BFS Approach
    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dist = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        //Adding all the zeros in queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            for (int[] d : dir) {

                int x = curr[0] + d[0];
                int y = curr[1] + d[1];

                //Only if its neighbour has a value greater than itself+1 we update the neighbour and add to queue
                if (dist[x][y] > dist[curr[0]][curr[1]] + 1) {
                    dist[x][y] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return dist;
    }


    public int[][] updateMatrixUsingDP(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE - 10000;
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) {
                        dist[i][j] = Integer.min(dist[i][j], dist[i - 1][j] + 1);
                    }

                    if (j > 0) {
                        dist[i][j] = Integer.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i < m - 1) {
                        dist[i][j] = Integer.min(dist[i][j], dist[i + 1][j] + 1);
                    }

                    if (j < n - 1) {
                        dist[i][j] = Integer.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
        }
        return dist;
    }


}
