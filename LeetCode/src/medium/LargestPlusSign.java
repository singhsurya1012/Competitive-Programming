package medium;

import java.util.HashSet;
import java.util.Set;

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int n, int[][] mines) {

        Set<Integer> banned = new HashSet();
        for (int[] mine: mines)
            banned.add(mine[0] * n + mine[1]);

        int[][] dp = new int[n][n];

        int count = 0;
        int ans = 0;
        for(int r=0; r<n;r++){
            count = 0;
            for(int c=0; c<n;c++){
                count = banned.contains(r*n+c)?0:count+1;
                dp[r][c] = count;
            }

            count = 0;
            for(int c=n-1;c>=0;c--){
                count = banned.contains(r*n+c)?0:count+1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for(int c=0;c<n;c++){
            count = 0;
            for(int r=0;r<n;r++){
                count = banned.contains(r*n+c)?0:count+1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for(int r=n-1;r>=0;r--){
                count = banned.contains(r*n+c)?0:count+1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }
        return ans;
    }
}
