package medium;

import java.util.*;

public class ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Integer> list = new LinkedList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        int set = 0;
        int n = arr.length;
        int size = 0;
        for(int i: list){

            size+= i;
            set++;
            if(size>=n/2){
                return set;
            }
        }

        return set;
    }
}
