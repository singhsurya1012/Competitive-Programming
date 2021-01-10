package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k == 0)
            return false;

        return binarySearchSolution(nums, k, t);
        //return bucketSortSolution(nums, k, t);
    }

    private boolean binarySearchSolution(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i <= k && i < nums.length; i++) {

            long val = nums[i];
            if (set.contains(val))
                return true;
            else {
                set.add(val);
            }
        }

        int j = k + 1;
        for (int i = 0; i < nums.length - 1; i++) {

            long toBeRemoved = nums[i];
            set.remove(toBeRemoved);

            Long closestElement = null;

            if ((closestElement = set.floor(toBeRemoved + t)) != null
                    && Math.abs(closestElement - toBeRemoved) <= t)
                return true;

            if (j < nums.length) {
                long toBeAdded = nums[j];
                if (set.contains(toBeAdded))
                    return true;
                else {
                    set.add(toBeAdded);
                    j++;
                }
            }
        }

        return false;
    }


    private boolean bucketSortSolution(int[] nums, int k, int t) {

        Map<Integer, Long> buckets = new HashMap<>();

        long width = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {

            long val = nums[i];
            int b = (int) Math.floorDiv(val, width);

            if (buckets.containsKey(b))
                return true;
            else if (buckets.containsKey(b - 1) && Math.abs(val - buckets.get(b - 1)) <= t)
                return true;
            else if (buckets.containsKey(b + 1) && Math.abs(val - buckets.get(b + 1)) <= t)
                return true;
            else
                buckets.put(b, val);

            if (i >= k) {
                int toBeRemoved = nums[i - k];
                buckets.remove((int) Math.floorDiv(toBeRemoved, width));
            }
        }

        return false;
    }


}
