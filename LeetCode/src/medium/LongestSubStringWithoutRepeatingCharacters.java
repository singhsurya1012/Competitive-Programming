package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        //Maintain the latest occurrence of each character
        Map<Character, Integer> map = new HashMap<>();

        //Start index is maintained to checknfor
        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            //If we encounter any duplicate character
            if (map.containsKey(c)) {

                int len = i - start;
                //update the max sub string length
                max = Math.max(len, max);
                //update the new start to the index of last duplicate character+1
                //only if its greater than the current start
                start = Math.max(start, map.get(c) + 1);

            }
            map.put(c, i);
        }

        //Check again if we didn't encounter any duplicate character in loop
        max = Math.max(s.length() - start, max);
        return max;
    }

}
