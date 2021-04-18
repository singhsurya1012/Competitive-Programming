package medium;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        //DownMoves = m-1
        //RightMoves = n-1
        int totalMoves = m+n-2;

        //So we have to either select m-1 places from total moves (m+n-1)C(m-1)
        //Or we have to select n-1 down moves from total moves (m+n-2)C(n-1)
        return totalCombinations(totalMoves, m<n?m-1:n-1);

    }


    public int totalCombinations(int n, int r){
        double val = 1;

        for(int i=1; i<=r; i++){

            val = val*(n-r+i)/i;
        }

        return (int)val;
    }

    public int pathsBottomUp(int m, int n){

        int[][] dp = new int[2][n+1];

        for(int i=m; i>=1; i--){
            for(int j=n; j>=1; j--){

                if(i==m || j==n){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }

        return dp[1][1];
    }

    public int pathsDP(int i, int j, int m, int n, int[][] dp){

        if(dp[i][j]!=0){
            return dp[i][j];
        }

        if(i==m && j==n){
            dp[i][j] = 1;
            return 1;
        }


        int p = 0;

        //Right
        if(isSafe(i,j+1,m,n)){
            p += pathsDP(i,j+1,m,n,dp);
        }

        //Down
        if(isSafe(i+1,j,m,n)){
            p +=pathsDP(i+1,j,m,n,dp);
        }

        dp[i][j] = p;
        return p;
    }

    public int paths(int i, int j, int m, int n){

        if(i==m && j==n){
            return 1;
        }

        int p = 0;

        //Right
        if(isSafe(i,j+1,m,n)){
            p += paths(i,j+1,m,n);
        }

        //Down
        if(isSafe(i+1,j,m,n)){
            p +=paths(i+1,j,m,n);
        }

        return p;
    }


    public boolean isSafe(int i, int j, int m, int n){

        return (i<=m) && (j<=n);
    }
}
