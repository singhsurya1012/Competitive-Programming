package medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int n = A.length;

        Map<Integer,Integer> sumMap = new HashMap<>();

        //Calculate all possible sum from last 2 array
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                int sum = C[i]+D[j];
                sumMap.put(sum, sumMap.getOrDefault(sum, 0)+1);
            }
        }
        int ans = 0;

        //For all possible sum in first 2 array check it its negative is present
        for(int i: A){
            for(int j: B){
                int sum = i+j;
                ans+=sumMap.getOrDefault(-sum,0);
            }
        }

        return ans;
    }
}
