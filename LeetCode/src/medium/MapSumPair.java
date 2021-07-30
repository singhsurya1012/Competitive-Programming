package medium;

import java.util.HashMap;
import java.util.Map;

public class MapSumPair {

    class MapSum {

        /** Initialize your data structure here. */
        Map<String,Integer> map;
        Map<String,Integer> prefixMap;
        public MapSum() {
            map = new HashMap<>();
            prefixMap = new HashMap<>();
        }

        public void insert(String key, int val) {

            int newVal = val - map.getOrDefault(key,0);
            map.put(key,val);

            String prefix = "";
            for(char c: key.toCharArray()){
                prefix+=c;
                prefixMap.put(prefix, prefixMap.getOrDefault(prefix,0)+newVal);

            }
        }

        public int sum(String prefix) {
            return prefixMap.getOrDefault(prefix,0);
        }
    }

    class MapSumTrie {

        /** Initialize your data structure here. */
        TrieNode root;
        Map<String,Integer> map;

        public MapSumTrie() {
            map = new HashMap<>();
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            int newVal = val - map.getOrDefault(key,0);
            map.put(key,val);

            TrieNode curr = root;
            curr.score+=newVal;

            for(char c: key.toCharArray()){

                curr.children.putIfAbsent(c,new TrieNode());
                curr = curr.children.get(c);
                curr.score+=newVal;
            }
        }

        public int sum(String prefix) {
            TrieNode curr = root;
            for(char c: prefix.toCharArray()){
                curr = curr.children.get(c);
                if(curr==null)
                    return 0;
            }

            return curr.score;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        int score;
    }
}
