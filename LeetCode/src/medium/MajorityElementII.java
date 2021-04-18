package medium;

import java.util.*;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        return findMajorityElement(nums, 3);
    }

    public List<Integer> findMajorityElement(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        //Iterating over all the elements
        for (int i : nums) {

            //If its present in map we simply increment its count
            //Else we check if map already has less than k-1 elements then we add the new element
            //Else if the map already contains k-1 elements we need to decrement the count of each element in map

            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else if (map.size() < k - 1) {
                map.put(i, 1);
            } else {

                Set<Map.Entry<Integer, Integer>> setOfEntries = map.entrySet();
                Iterator<Map.Entry<Integer, Integer>> iterator = setOfEntries.iterator();

                while (iterator.hasNext()) {

                    //Important to use iterator so that we dont encounter Concurrent Modification Exception
                    //If the count is 1 we need to remove it from map

                    Map.Entry<Integer, Integer> entry = iterator.next();
                    Integer value = entry.getValue();

                    if (value == 1) {
                        iterator.remove();
                    } else {
                        map.put(entry.getKey(), value - 1);
                    }
                }

            }
        }

        //Once we have iterated through the array we need to check if the elements in the map actually appear more than n/k times

        //Initialize all the counts back to zero and again iterate over the array and increment their count
        map.forEach((key, val) -> {
            map.put(key, 0);
        });

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }


        List<Integer> list = new ArrayList<>();

        //Finally check if the count is more than n/k we can add it to the list.
        map.forEach((key, val) -> {
            if (val > n / k) {
                list.add(key);
            }
        });
        return list;
    }

}
