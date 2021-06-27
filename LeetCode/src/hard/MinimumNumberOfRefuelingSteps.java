package hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingSteps {

    Integer[][] dp;
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int n = stations.length;
        //dp = new Integer[n+1][n+1];
        //return minSteps(0, target, startFuel, stations);


        return minsStepHeap(target, startFuel, stations);
    }

    private int minsStepHeap(int target, int fuel, int [][] stations){

        int N = stations.length;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int refills = 0;

        int prev = 0;
        for(int[]s :stations){

            fuel = fuel - (s[0]-prev);

            //Try to refill in past
            while(!q.isEmpty() && fuel<0){
                fuel = fuel + q.poll();
                refills++;
            }

            //Even after refilling every time in the past if fuel is less than zero
            //means we cant reach
            if(fuel<0){
                return -1;
            }

            q.offer(s[1]);
            prev = s[0];
        }


        //Check if from the last station we can reach target;

        fuel = fuel - (target-prev);
        while(!q.isEmpty() && fuel<0){
            fuel = fuel + q.poll();
            refills++;
        }

        if(fuel<0){
            return -1;
        }

        return refills;

    }


    //dp[stops] means the furthest distance that we can get with stops times of refueling.
    public int minStepsDp(int target, int startFuel, int[][] s) {

        int N = s.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;

        for(int i=0; i<N;i++){
            for(int stops=i; stops>=0; stops--){
                if(dp[stops]>=s[i][0]){
                    dp[stops+1]=Math.max(dp[stops+1],dp[stops]+ s[i][1]);
                }
            }
        }


        for (int stops = 0; stops <= N; stops++)
            if (dp[stops] >= target) return stops;
        return -1;
    }

    public int minSteps(int index, int target, int fuel, int[][] stations){

        int current = (index==0)?0:stations[index-1][0];

        if(current+fuel>=target)
            return 0;

        if(dp[index][fuel]!=null)
            return dp[index][fuel];

        int n = stations.length;

        int minSteps = Integer.MAX_VALUE;

        for(int i=n-1; i>=0;i--){

            int[] s = stations[i];

            if(s[0]<=current)
                break;

            if(current + fuel>=s[0]){
                int remainingfuel = fuel - (s[0] - current) + s[1];
                int refills = minSteps(i+1,target,remainingfuel, stations);
                if(refills!=-1){
                    minSteps = Math.min(minSteps,refills+1);
                }
            }
        }

        dp[index][fuel] = (minSteps==Integer.MAX_VALUE)?-1:minSteps;
        return dp[index][fuel];
    }
}
