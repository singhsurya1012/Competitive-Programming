package medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    private static int m;
    private static int n;

    //Time Complexity = O(m*n)
    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int islands = 0;

        //We Need to find all the connected components which can be done by BFS or DFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    //Calling DFS/DFS will mark all the connected components from this node
                    islands++;
                    DFS(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void DFS(char grid[][], int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] x : dir) {
            DFS(grid, i + x[0], j + x[1]);
        }
    }

    public void BFS(char grid[][], int i, int j) {

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        grid[i][j] = '0';

        while (q.size() > 0) {
            int[] curr = q.poll();

            for (int[] d : dir) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];

                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
                    continue;
                grid[r][c] = '0';
                q.add(new int[]{r, c});
            }
        }

    }

}
