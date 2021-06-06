package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<Integer>();
        for(int num:nums){
            numSet.add(num);
        }

        int longestStreak = 0;

        for(int num:numSet){

            //No need to check since it will be included in (num-1) iteration
            if(numSet.contains(num-1))
                continue;

            int curr = num;
            int currentSequence = 1;

            while(numSet.contains(curr+1)){
                currentSequence+=1;
                curr+=1;
            }
            longestStreak = Math.max(longestStreak, currentSequence);
        }

        return longestStreak;
    }

    public int  longestConsecutiveBruteForce(int[] nums) {

        int longestSequence = 0;

        for(int num:nums){

            int curr = num;
            int currentSequence = 1;

            while(arrayContains(nums, curr+1)){
                currentSequence++;
                curr++;
            }

            longestSequence = Math.max(longestSequence, currentSequence);

        }

        return longestSequence;
    }


    private boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }
}
