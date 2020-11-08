package medium;

import java.util.*;

public class InsertDeleteGetRandom {

    class RandomizedSet {

        /** Initialize your data structure here. */
        Map<Integer,Integer> map;
        List<Integer> list;
        Random r;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            r = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            Integer k = map.get(val);
            if(k==null){
                int index = list.size();
                map.put(val,index);
                list.add(val);
                return true;
            }
            return false;

        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            Integer k = map.get(val);
            if(k!=null){
                int lastIndex = list.size()-1;
                list.set(k,list.get(lastIndex));
                map.put(list.get(k), k);
                list.remove(lastIndex);
                map.remove(val);
                return true;

            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = r.nextInt(list.size());
            return list.get(index);
        }
    }


}
