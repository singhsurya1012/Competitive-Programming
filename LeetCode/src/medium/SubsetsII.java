package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        List<List<Integer>> prev = new ArrayList<>();


        for(int i=0;i<n;i++){

            List<List<Integer>> temp = null;
            if(i!=0 && nums[i]==nums[i-1]){
                temp = prev;
            }else{
                temp = result;
            }

            List<List<Integer>> current = new ArrayList<>();
            for(List<Integer> oldList : temp){
                List<Integer> l = new ArrayList<>(oldList);
                l.add(nums[i]);
                current.add(l);
            }
            prev = current;
            result.addAll(current);

        }

        return result;
    }

    public List<List<Integer>> subsetsWithDupClean(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        int start = 0;

        for (int i = 0; i < n; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                start = 0;
            }
            for (int size = result.size(); start < size; start++) {
                List<Integer> l = new ArrayList<>(result.get(start));
                l.add(nums[i]);
                result.add(l);
            }
        }

        return result;
    }
}
