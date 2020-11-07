package easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {

        if (J == null || J.length() == 0)
            return 0;

        Set<Character> jewels = new HashSet<>();

        for (char c : J.toCharArray()) {
            jewels.add(c);
        }

        int ans = 0;
        for (char c : S.toCharArray()) {
            if (jewels.contains(c))
                ans++;
        }

        return ans;

    }
}
