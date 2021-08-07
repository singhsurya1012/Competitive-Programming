package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        int n = s.length();
        if(n<=1){
            return n;
        }

        Map<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int maxLength = 0;
        boolean odd = false;
        for(int i: map.values()){

            if(i%2==0){
                maxLength +=i;
            }else{
                odd = true;
                maxLength = maxLength + i - 1;
            }
        }

        return maxLength + (odd?1:0);

    }

}
