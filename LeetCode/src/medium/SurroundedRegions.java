package medium;

public class SurroundedRegions {

    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int m = 0;
    int n = 0;

    public void solve(char[][] board) {

        m = board.length;
        n = board[0].length;

        //firstRow and lastrow
        for (int col = 0; col < n; col++) {

            if (board[0][col] == 'O')
                dfs(board, 0, col);

            if (board[m - 1][col] == 'O')
                dfs(board, m - 1, col);

        }


        //firstCol and lastcol
        for (int row = 0; row < m; row++) {

            if (board[row][0] == 'O')
                dfs(board, row, 0);

            if (board[row][n - 1] == 'O')
                dfs(board, row, n - 1);
        }


        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (board[row][col] == 'O')
                    board[row][col] = 'X';
                else if (board[row][col] == '1')
                    board[row][col] = 'O';
            }
        }
    }


    public void dfs(char[][] board, int i, int j) {

        board[i][j] = '1';

        for (int[] d : dir) {

            int x = i + d[0];
            int y = j + d[1];
            if (isSafe(x, y) && board[x][y] == 'O') {
                dfs(board, x, y);
            }
        }
    }


    public boolean isSafe(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
