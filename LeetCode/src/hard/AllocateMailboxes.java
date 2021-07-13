package hard;

import java.util.Arrays;

public class AllocateMailboxes {

    Integer[][] dp ;

    public int minDistance(int[] houses, int k) {

        int n = houses.length;
        if(k==n)
            return 0;

        Arrays.sort(houses);

        dp = new Integer[k + 1][n];

        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for(int curr=i; curr<=j;curr++){
                    cost[i][j] += Math.abs(houses[(i+j)/2] - houses[curr]);
                }
            }
        }

        return findDistance(houses, cost, k, 0);
    }

    public int findDistance(int[] houses,int[][] cost, int k, int pos){

        if(k==0 && pos==houses.length)
            return 0;

        if(k==0 || pos==houses.length)
            return Integer.MAX_VALUE;

        if(dp[k][pos]!=null)
            return dp[k][pos];

        int ans = Integer.MAX_VALUE;
        for(int j=pos; j<houses.length;j++){
            int dis = findDistance(houses,cost,k-1,j+1);
            if(dis!=Integer.MAX_VALUE){
                ans = Math.min(ans, cost[pos][j] + dis);
            }
        }

        dp[k][pos] = ans;
        return ans;
    }
}
