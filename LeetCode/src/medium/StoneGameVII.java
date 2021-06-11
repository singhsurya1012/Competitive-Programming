package medium;

public class StoneGameVII {

    Integer[][] dp;

    public int stoneGameVII(int[] stones) {

        int n = stones.length;

        int sum = 0;
        for(int i:stones)
            sum+=i;

        dp = new Integer[n][n];
        return stoneGame(stones,sum,0, n-1);
    }

    public int stoneGame(int[] stones,int sum, int l, int r){

        if(l==r){
            return 0;
        }

        if(dp[l][r]!=null)
            return dp[l][r];

        int leftRemove = sum-stones[l] - stoneGame(stones, sum-stones[l], l+1, r);
        int rightRemove = sum-stones[r] - stoneGame(stones, sum-stones[r], l, r-1);

        dp[l][r] = Math.max(leftRemove,rightRemove);

        return dp[l][r];
    }

    public int stoneGameVIIBottomUp(int[] stones) {

        int n = stones.length;
        int[] pre = new int[n];
        pre[0] = stones[0];

        for(int i=1; i<n;i++){
            pre[i] = pre[i-1]+stones[i];
        }

        int dp[][] = new int[n][n];

        for(int len=2; len<=n;len++){

            for(int i=0; i+len<=n;i++){

                int j = i+len-1;

                int leftRemove = getSum(pre,i+1,j) - dp[i+1][j];
                int rightRemove = getSum(pre,i,j-1) - dp[i][j-1];

                dp[i][j] = Math.max(leftRemove,rightRemove);
            }
        }

        return dp[0][n-1];
    }


    public int getSum(int[] pre, int l, int r){
        return  (pre[r] - (l!=0? pre[l-1]:0));
    }

}
