package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MaximumLengthOfRepeatedSubArray {

    public int findLength(int[] A, int[] B) {

        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];

        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    public int findLengthBruteForce(int[] nums1, int[] nums2) {

        if(nums2.length>nums1.length){
            int[] temp  = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        Map<Integer, List<Integer>> map =new HashMap<>();

        for(int i=0; i<nums1.length;i++){
            if(!map.containsKey(nums1[i]))
                map.put(nums1[i], new LinkedList<>());

            map.get(nums1[i]).add(i);
        }


        int maxSize = 0;
        for(int i=0; i<nums2.length;i++){

            if(map.containsKey(nums2[i])){

                for(int x : map.get(nums2[i])){

                    int size = compare(x,nums1,i,nums2);
                    maxSize = Math.max(size,maxSize);

                }

            }

            if(maxSize==nums2.length)
                return maxSize;

        }

        return maxSize;

    }


    public int compare(int i, int[] nums1, int j, int[] nums2){
        int size = 0;
        while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]){
            size++;
            i++;
            j++;
        }

        return size;
    }
}
