package medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list =  map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue()-o1.getValue())
                .collect(Collectors.toList());

        int[] ans = new int[k];
        for(int i=0; i<k;i++){
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }
}
