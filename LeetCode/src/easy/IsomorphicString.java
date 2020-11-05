package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            char k = s.charAt(i);
            char v = t.charAt(i);

            //If we have already seen the character of s
            //Then its mapping should be equal to current character in t
            if (map.containsKey(k)) {

                if (v != map.get(k))
                    return false;
            } else {

                //Check if we have already created mapping with the character in t
                if (set.contains(v))
                    return false;

                //Add mapping
                map.put(k, v);
                //Add in set to indicate that the character is already used by some mapping
                set.add(v);
            }
        }

        return true;
    }
}
