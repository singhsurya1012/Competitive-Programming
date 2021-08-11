package medium;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] arr) {

        Map<Integer,Integer> map = new TreeMap<>();
        for(int i:arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(int key: map.keySet()){

            int values = map.get(key);

            if(values==0)
                continue;

            int pair = 0;

            if(key<0){
                if(key%2!=0)
                    return false;
                pair = key/2;
            }else{
                pair = key*2;
            }

            int pairValue = map.getOrDefault(pair,0);

            if(pairValue<values)
                return false;

            pairValue = pairValue-values;
            map.put(pair, pairValue);
        }

        return true;

    }
}
