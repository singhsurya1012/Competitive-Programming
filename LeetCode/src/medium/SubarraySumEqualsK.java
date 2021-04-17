package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {


    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int n = nums.length;

        int sum = 0;
        int count = 0;

        for(int i=0; i<n;i++){
            sum+=nums[i];

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return count;
    }

    public int subarraySumSlow(int[] nums, int k) {

        int n = nums.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0];

        for(int i=1; i<n; i++){
            prefixSum[i] =prefixSum[i-1]+nums[i];
        }

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i; j<n; j++){

                if(prefixSum[j]-prefixSum[i]+nums[i]==k){
                    count++;
                }
            }
        }

        return count;
    }
}
