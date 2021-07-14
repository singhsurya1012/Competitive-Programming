package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();

        int[] max = new int[n-k+1];
        int index = 0;
        for(int i=0; i<n;i++){

            //Out of range elements;
            while(!q.isEmpty() && q.peekFirst()<i-k-1){
                q.pollFirst();
            }

            while(!q.isEmpty() && q.peekLast()<nums[i]){
                q.pollLast();
            }
            q.offerFirst(i);

            if(i>=k-1){
                max[index++] = nums[q.peekFirst()];
            }
        }
        return max;

    }

    public int[] maxSlidingWindowOptimised(int[] nums, int k) {

        int n = nums.length;
        int[] maxLeft  = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = nums[0];
        maxRight[n-1] = nums[n-1];

        for(int i=1; i<n;i++){

            maxLeft[i] = (i%k==0)?nums[i]:Math.max(maxLeft[i-1],nums[i]);

            int j = n- i -1;
            maxRight[j] = (j%k==0)?nums[j]:Math.max(maxRight[j+1],nums[j]);
        }

        int[] max = new int[n-k+1];

        for(int i=0,j=0; i+k <=n;i++, j++){
            max[j] = Math.max(maxLeft[i+k-1], maxRight[i]);
        }

        return max;
    }

}
