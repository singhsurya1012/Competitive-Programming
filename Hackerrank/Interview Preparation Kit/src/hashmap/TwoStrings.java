package hashmap;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        Set<Character> set = new HashSet<>();

        //Any bigger common substring will also have a single character common
        //So we just need to check if there is any common character between the two string
        for (char c : s1.toCharArray()) {
            set.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                return "YES";
            }
        }

        return "NO";

    }

}
