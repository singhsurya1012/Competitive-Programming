package easy;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    //BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int m = image.length;
        int n = image[0].length;

        int[][] visited = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        //Starting from the original Position
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = -1;

        int originalColor = image[sr][sc];

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {

            int[] pos = q.poll();
            int i = pos[0];
            int j = pos[1];

            //Change its color to queue
            image[i][j] = newColor;

            for (int[] d : dir) {

                int x = i + d[0];
                int y = j + d[1];

                //Check if its possible to move in any 4 direction add it to the queue
                if (x >= 0 && x < m && y >= 0 && y < n && visited[x][y] != -1 && image[x][y] == originalColor) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = -1;
                }
            }
        }
        return image;

    }

}
