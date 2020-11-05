package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrayII {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums1){

            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i,1);
        }

        List<Integer> l = new ArrayList<>();
        for(int i: nums2){
            if(map.containsKey(i)){
                l.add(i);
                int x = map.get(i);
                x--;
                if(x==0)
                    map.remove(i);
                else
                    map.put(i,x);
            }
        }

        int[] arr = new int[l.size()];
        int index = 0;
        for(int i: l){
            arr[index++] = i;
        }

        return arr;
    }
}
