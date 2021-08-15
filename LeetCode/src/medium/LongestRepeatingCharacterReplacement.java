package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int n = s.length();
        if(k>=n){
            return n;
        }

        int len = 0;
        int max = 0;

        int[] arr = new int[26];
        int l = 0;
        int r = 0;
        while(r<n){

            char c = s.charAt(r);

            arr[c-'A']++;
            max = Math.max(max,arr[c-'A']);

            if( r-l+1 -max>k){

                arr[s.charAt(l)-'A']--;
                l++;
            }
            len = Math.max(len, r-l+1);
            r++;
        }

        return len;
    }


    public int characterReplacementSlow(String s, int k) {

        int l = 0;
        int r = 0;
        int n = s.length();

        if(k>=n){
            return n;
        }

        int len = 0;

        int totalChars = 0;

        Map<Character,Integer> map = new HashMap<>();
        while(r<n){

            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);

            while(!isValid(map,k)){

                char remove = s.charAt(l);
                map.put(remove, map.get(remove)-1);
                l++;
            }
            len = Math.max(len, r-l+1);
            r++;
        }

        return len;
    }


    public boolean isValid(Map<Character,Integer> map, int k){

        int totalChars = 0;
        int max = 0;

        for(int v : map.values()){
            totalChars+=v;
            max = Math.max(max,v);
        }

        int remainingChars = totalChars - max;
        return remainingChars<=k;
    }
}
