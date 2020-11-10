package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class CastleOnTheGrid {


    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        char[][] matrix = new char[grid.length][];
        int index = 0;
        for (String s : grid) {
            matrix[index++] = s.toCharArray();
        }


        Queue<int[]> q = new LinkedList<>();
        int moves = 0;
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                if (x == goalX && y == goalY) {
                    return moves;
                }

                //Left
                for (int i = y - 1; i >= 0; i--) {

                    if (matrix[x][i] == '.') {
                        q.offer(new int[]{x, i});
                        matrix[x][i] = '0';
                    } else if (matrix[x][i] == 'X') {
                        break;
                    }
                }

                //Right
                for (int i = y + 1; i < matrix.length; i++) {

                    if (matrix[x][i] == '.') {
                        q.offer(new int[]{x, i});
                        matrix[x][i] = '0';
                    } else if (matrix[x][i] == 'X') {
                        break;
                    }
                }

                //Up
                for (int i = x - 1; i >= 0; i--) {

                    if (matrix[i][y] == '.') {
                        q.offer(new int[]{i, y});
                        matrix[i][y] = '0';
                    } else if (matrix[i][y] == 'X') {
                        break;
                    }
                }


                //Down
                for (int i = x + 1; i < matrix.length; i++) {

                    if (matrix[i][y] == '.') {
                        q.offer(new int[]{i, y});
                        matrix[i][y] = '0';
                    } else if (matrix[i][y] == 'X') {
                        break;
                    }
                }

            }

            moves++;

        }

        return moves;
    }
}
