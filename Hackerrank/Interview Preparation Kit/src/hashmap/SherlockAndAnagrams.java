package hashmap;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {


        Map<String, Integer> map = new HashMap<>();

        int ans = 0;
        //We maintain a map with key as sorted string
        //So two anagrams will have the same key since its sorted
        //For every substring we check the count of same strings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                String str = s.substring(i, j);
                str = sort(str);
                ans += map.getOrDefault(str, 0);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        return ans;
    }

    //Since we know the range of characters we can sort using array in O(N) complexity
    static String sort(String s) {

        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

}
