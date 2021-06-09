package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combination(candidates, 0, target, new ArrayList<>());
        return result;
    }


    private void combination(int[] c, int pos, int target, List<Integer> list){

        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }

        if(pos==c.length)
            return;

        //Keep adding the current element till its possible
        if(c[pos]<=target){
            list.add(c[pos]);
            combination(c,pos, target-c[pos], list);
            list.remove(list.size()-1);
        }

        combination(c,pos+1,target, list);
        return;

    }
}
