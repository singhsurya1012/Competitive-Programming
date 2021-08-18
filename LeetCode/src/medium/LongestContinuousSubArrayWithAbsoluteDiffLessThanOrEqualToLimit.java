package medium;

import java.util.*;

public class LongestContinuousSubArrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int n = nums.length;

        while(r<n){

            while(!max.isEmpty() && nums[r]>max.peekLast()){
                max.pollLast();
            }

            while(!min.isEmpty() && nums[r]<min.peekLast()){
                min.pollLast();
            }

            max.add(nums[r]);
            min.add(nums[r]);

            while(max.peek()-min.peek()>limit){

                if(max.peek()==nums[l])
                    max.poll();

                if(min.peek()==nums[l])
                    min.poll();

                l++;
            }

            maxLen = Math.max(maxLen,r-l+1);
            r++;

        }
        return maxLen;
    }

    public int longestSubarrayPQ(int[] nums, int limit) {

        int l = 0;
        int r = 0;

        int n = nums.length;
        int maxLen = 0;

        TreeMap<Integer,Integer> map = new TreeMap<>();

        while(r<n){

            map.put(nums[r], map.getOrDefault(nums[r],0)+1);

            while(map.lastEntry().getKey() - map.firstEntry().getKey()>limit){
                map.put(nums[l], map.get(nums[l])-1);

                if(map.get(nums[l])==0)
                    map.remove(nums[l]);

                l++;
            }

            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }

        return maxLen;

    }


    public int longestSubarraySlow(int[] nums, int limit) {

        int l = 0;
        int r = 1;

        int n = nums.length;
        int maxLen = 1;

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        min.offer(nums[0]);
        max.offer(nums[0]);

        while(r<n) {

            min.offer(nums[r]);
            max.offer(nums[r]);

            while(max.peek()-min.peek()>limit){
                max.remove(nums[l]);
                min.remove(nums[l]);
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;

        }

        return maxLen;
    }
}
