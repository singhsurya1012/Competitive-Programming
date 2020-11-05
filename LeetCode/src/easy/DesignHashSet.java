package easy;

import java.util.LinkedList;
import java.util.List;

public class DesignHashSet {

    class MyHashSet {

        /**
         * Initialize your data structure here.
         */
        private final List[] set;

        public MyHashSet() {
            set = new List[1000];
        }

        public void add(int key) {
            int index = hash(key);

            if (null == set[index]) {
                List<Integer> list = new LinkedList<>();
                list.add(key);
                set[index] = list;
            } else {
                List<Integer> list = set[index];

                for(int i: list){
                    if(i==key)
                        return;
                }
                list.add(key);
            }
        }

        public void remove(int key) {
            int index = hash(key);
            if (null != set[index]) {
                List<Integer> list = set[index];
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == key) {
                        list.remove(i);
                        return;
                    }
                }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int index = hash(key);

            if (null == set[index]) {
                return false;
            } else {
                List<Integer> list = set[index];
                for (int i : list) {
                    if (i == key)
                        return true;
                }
            }

            return false;
        }

        private int hash(int key) {
            return key % 1000;
        }
    }

}
