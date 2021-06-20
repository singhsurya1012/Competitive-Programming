package hard;

public class KInversePairArray {

    int mod = 1000000007;
    Integer[][] dp;
    public int kInversePairs(int n, int k) {

        if(k==0)
            return 1;

        int max = (n*(n-1))/2;

        if(k>max)
            return 0;

        if(k==max)
            return 1;

        dp = new Integer[n+1][k+1];
        //return kInversePairsRec(n,k);
        return kInversePairsBottomUpOptimised(n,k);

    }


    public int kInversePairsRec(int n, int k){

        if(n==0)
            return 0;

        if(k==0)
            return 1;

        if(dp[n][k]!=null)
            return dp[n][k];

        int inv = 0;

        for(int  i=0; i<=Math.min(k, n-1); i++){
            inv = (inv+ kInversePairsRec(n-1,k-i)) %mod;
        }

        dp[n][k] = inv;
        return inv;
    }

    public int kInversePairsBottomUp(int n, int k) {


        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                if(j==0)
                    dp[i][j]=1;
                else{

                    for (int p = 0; p <= Math.min(j, i - 1); p++)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % 1000000007;

                }
            }
        }

        return dp[n][k];
    }

    public int kInversePairsBottomUpOptimised(int n, int k) {


        int[][] dp = new int[n + 1][k + 1];
        dp[1][0]=1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] =1;
            for (int j = 1; j <= k; j++) {


                dp[i][j] = (dp[i][j-1]+dp[i-1][j])%mod;
                if(j>=i)
                    dp[i][j] -= dp[i-1][j-i];

                dp[i][j] = (dp[i][j]+mod) % mod;

            }
        }

        return dp[n][k];
    }
}
