package easy;

import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {

        Map<Character, Integer> map = Map.of(
                'I', 1, 'V', 5, 'X', 10, 'L', 50,
                'C', 100, 'D', 500, 'M', 1000);

        int n = s.length();
        int val = 0;

        for(int i=0; i<n-1;i++){
            int curr = map.get((s.charAt(i)));
            int next = map.get(s.charAt(i+1));

            if(curr<next)
                val-=curr;
            else
                val+=curr;
        }

        val+=map.get(s.charAt(n-1));
        return val;
    }
}
