package easy;

import java.util.HashMap;

public class DesignHashMap {

    class MyHashMap {

        /** Initialize your data structure here. */
        private int[] map;
        public MyHashMap() {
            map = new int[1000001];

            for(int i=0; i<1000001;i++){
                map[i] = -1;
            }

        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            map[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return map[key];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            map[key] = -1;
        }
    }
}
