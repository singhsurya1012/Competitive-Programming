package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

        //This map maintains the count of each value
        Map<Integer, Integer> map = new HashMap<>();
        //This map maintains the frequency of count
        Map<Integer, Integer> freq = new HashMap<>();

        List<Integer> ans = new ArrayList<>();

        for (List<Integer> q : queries) {

            int type = q.get(0);
            int val = q.get(1);

            //If value is added
            if (type == 1) {

                //Decrease the frequency of old count
                int f = map.getOrDefault(val, 0);
                if (f != 0)
                    freq.put(f, freq.get(f) - 1);

                f = f + 1;
                //Add in Map and increase its count
                map.put(val, f);
                //Increase the frequency of new count
                freq.put(f, freq.getOrDefault(f, 0) + 1);

            } else if (type == 2) {

                //If value is removed
                if (map.containsKey(val)) {

                    //Decrease the old frequency of old count
                    int f = map.get(val);
                    freq.put(f, freq.get(f) - 1);

                    f = f - 1;

                    //If count is 0 we remove it from map
                    if (f == 0)
                        map.remove(val);
                    else {
                        //Else Decrease the count of value
                        map.put(val, f);
                        //Increase the frequency of new count
                        freq.put(f, freq.getOrDefault(f, 0) + 1);
                    }

                }

            } else {
                //Simply check if the frequency is present and is greater than zero
                if (freq.containsKey(val) && freq.get(val) > 0) {
                    ans.add(1);
                } else {
                    ans.add(0);
                }
            }
        }

        return ans;
    }

}
