package medium;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        Integer[][] dp = new Integer[m][n];

        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
            return 0;

        //return paths(obstacleGrid, 0,0, m, n, dp);
        return pathsDp(obstacleGrid);
    }

    public int pathsDp(int[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for(int i=m-1; i>=0;i--) {
            for(int j = n-1;j>=0;j--){

                if(grid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }

                if(i<m-1)
                    dp[i][j] +=dp[i+1][j];

                if(j<n-1)
                    dp[i][j]+=dp[i][j+1];

            }
        }

        return dp[0][0];
    }


    public int paths(int[][] grid, int i, int j, int m, int n, Integer[][] dp){

        if(i==m-1 && j==n-1)
            return 1;

        if(dp[i][j]!=null)
            return dp[i][j];

        int p = 0;

        if(i+1<m && grid[i+1][j]!=1)
            p+=paths(grid,i+1,j,m,n,dp);

        if(j+1<n && grid[i][j+1]!=1)
            p+=paths(grid,i,j+1,m,n,dp);

        dp[i][j] = p;
        return p;

    }
}
