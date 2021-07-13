package medium;

import java.util.*;

public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {

        int n  =nums.length;

        int[][] dp = new int[n][1001];

        int longest = 2;

        for(int i = 1; i<n;i++){
            for(int j = 0; j<i ;j++){

                int len = 2;
                int diff = nums[i]-nums[j];

                dp[i][diff+500] = Math.max (len , 1+ dp[j][diff+500]);
                longest = Math.max(longest, dp[i][diff+500]);
            }
        }

        return longest;

    }

    public int longestArithSeqLengthDP(int[] nums) {

        int n  =nums.length;
        int longest = 2;

        Map<Integer,Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<Integer, Integer>();
        }


        for(int i = 1; i<n ;i++){
            for(int j=0; j<i; j++){

                int d = nums[i]-nums[j];

                int len = 2;

                if(dp[j].containsKey(d)){
                    len = dp[j].get(d)+1;
                }

                int curr = dp[i].getOrDefault(d,0);

                dp[i].put(d, Math.max(len,curr));

                longest = Math.max(longest, dp[i].get(d));
            }
        }

        return longest;

    }


    public int longestArithSeqLengthSlow(int[] nums) {

        int n  =nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0;i<n;i++){

            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<Integer>());

            map.get(nums[i]).add(i);
        }


        int max = 1;
        for(int i=0; i<n;i++){
            for(int j=i+1;j<n; j++){

                int a = nums[i];
                int b = nums[j];

                int d = b-a;

                int len = 2;

                int next = b+d;
                int prev = j+1;

                while(next>=0 && map.containsKey(next)){

                    List<Integer> list = map.get(next);

                    int x = Collections.binarySearch(list,prev);

                    if(x<0)
                        x = -x-1;

                    if(x==list.size())
                        break;

                    len++;
                    next = next+d;
                    prev=list.get(x)+1;
                }

                max = Math.max(len,max);
            }
        }

        return max;
    }
}
