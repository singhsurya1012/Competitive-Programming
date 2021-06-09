package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class JumpGameVI {

    Integer[] dp;
    public int maxResult(int[] nums, int k) {

        dp = new Integer[nums.length];

        return maxResult(nums, 0,nums.length, k);
    }

    public int maxResult(int[] nums, int curr,int n, int k){

        if(curr==n-1)
            return nums[curr];

        if(dp[curr]!=null)
            return dp[curr];

        int score = Integer.MIN_VALUE;

        for(int i=1; i<=k && curr+i<n ;i++){
            score = Math.max(score, maxResult(nums,curr+i,n,k));
        }

        dp[curr] = nums[curr]+score;
        return dp[curr];

    }

    public int maxResultDp(int[] nums, int k){

        int n = nums.length;

        int[] dp = new int[n];
        dp[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--){
            int max = Integer.MIN_VALUE;

            for(int j=1; j<=k && i+j<n; j++){
                max = Math.max(max, dp[i+j]);
            }
            dp[i] = nums[i]+max;
        }

        return dp[0];

    }

    public int maxResultBottomUp(int[] nums, int k){

        int n = nums.length;

        int[] dp = new int[n];
        dp[n-1] = nums[n-1];

        Deque<Integer> queue  = new ArrayDeque<>();
        queue.offer(n-1);

        for(int i=n-2; i>=0; i--) {

            dp[i] = nums[i]+ dp[queue.getFirst()];

            while(!queue.isEmpty() && dp[i] > dp[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(i);

            if(queue.getFirst() >= i+k){
                queue.removeFirst();
            }

        }
        return dp[0];
    }

}
