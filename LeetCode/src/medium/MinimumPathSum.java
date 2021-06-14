package medium;

public class MinimumPathSum {

    Integer[][] dp;
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new Integer[m][n];
        //return move(grid, 0,0, m,n);
        return moveBottomUp(grid);
    }


    public int move(int[][] grid, int i, int j , int m , int n){

        if(i==m-1 && j==n-1)
            return grid[i][j];

        if(dp[i][j]!=null)
            return dp[i][j];

        int move = Integer.MAX_VALUE;

        //Right
        if(isSafe(i,j+1,m,n)){
            move = move(grid, i,j+1,m,n);
        }

        //Down
        if(isSafe(i+1, j, m, n)){
            move = Math.min(move , move(grid,i+1,j,m,n));
        }

        dp[i][j] = grid[i][j]+move;
        return dp[i][j];
    }


    public boolean isSafe(int i, int j, int m, int n){
        return (i>=0 && i<m && j>=0 && j<n);
    }


    public int moveBottomUp(int[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = grid[m-1][n-1];

        //lastRow
        for(int i = n-2; i>=0; i--){
            dp[m-1][i] = grid[m-1][i] + dp[m-1][i+1];
        }

        //lastCol
        for(int i= m-2;i>=0;i--){
            dp[i][n-1] = grid[i][n-1] + dp[i+1][n-1];
        }

        for(int i = m-2; i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = grid[i][j]+Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
