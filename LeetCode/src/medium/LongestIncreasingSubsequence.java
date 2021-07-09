package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i=1; i<n;i++){

            int val = nums[i];

            if(val>list.get(list.size()-1)){
                list.add(val);
            }else{

                int j = binarySearch(list,val);
                list.set(j, val);
            }

        }

        return list.size();

    }

    private int binarySearch(List<Integer> list, int num) {

        int l =0;
        int r = list.size()-1;

        while(l<r){

            int m = (l+r)/2;

            if(list.get(m) == num)
                return m;
            else if(list.get(m)<num){
                l = m+1;
            }else{
                r = m;
            }
        }

        return l;
    }


    public int lengthOfLISSlow(int[] nums) {

        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i=1; i<n;i++){

            int val = nums[i];

            if(val>list.get(list.size()-1)){
                list.add(val);
            }else{

                int j = 0;
                while(val>nums[j]){
                    j++;
                }

                list.set(j, val);
            }

        }

        return list.size();

    }

    public int lengthOfLISDP(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i=1 ; i<n ;i++){
            for(int j=0; j<i;j++){

                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max = 0;
        for(int i: dp){
            max = Math.max(i,max);
        }

        return max;
    }
}
