package medium;

public class OutOfBoundaryPaths {

    int mod = 1000000007;
    Integer[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {


        if(maxMove==0)
            return 0;

        dp = new Integer[maxMove+1][m+1][n+1];

        return paths(m,n, maxMove, startRow, startColumn);

    }


    public int paths(int m, int n, int moves, int i, int j){

        if(i<0 || i>=m || j<0 || j>=n)
            return 1;

        if(moves==0)
            return 0;

        if(dp[moves][i][j]!=null)
            return dp[moves][i][j];

        int ans = 0;

        ans =  (paths(m,n,moves-1,i,j+1)%mod + paths(m,n,moves-1,i,j-1)%mod) %mod;
        ans += (paths(m,n,moves-1,i+1,j)%mod + paths(m,n,moves-1,i-1,j)%mod) %mod;


        dp[moves][i][j] = ans%mod;
        return dp[moves][i][j];

    }

    public int findPathsBottomUp(int m, int n, int maxMove, int startRow, int startColumn) {

        int M = 1000000000 + 7;
        int dp[][] = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;

        for(int moves=1;moves<=maxMove;moves++){
            int[][] temp = new int[m][n];

            for(int i=0; i<m; i++){
                for(int j=0; j<n ; j++){

                    if(i==0)
                        count = (count+dp[i][j])%M;
                    if(j==0)
                        count = (count+dp[i][j])%M;
                    if(i==m-1)
                        count = (count+dp[i][j])%M;
                    if(j==n-1)
                        count = (count+dp[i][j])%M;

                    temp[i][j] = (
                            ( ( i>0 ? dp[i-1][j] : 0 ) + ( i<m-1 ? dp[i+1][j] : 0 ))%M +
                                    ( (j>0 ? dp[i][j-1] : 0 ) + (j<n-1 ? dp[i][j+1] : 0 ))%M
                    )%M;
                }
            }

            dp = temp;
        }
        return count;
    }
}
