package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {

        //return longestSubstringDivide(s,k,0,s.length());
        return longestSubstringTwoPointer(s,k);

    }

    public int longestSubstringTwoPointer(String s, int k){

        char[] c = s.toCharArray();
        int[] arr = new int[26];

        int maxUniqueChar = getMaxUniqueChar(s);
        int max = 0;

        for(int i = 1; i<=maxUniqueChar;i++){

            Arrays.fill(arr,0);

            int l = 0;
            int r = 0;
            int unique = 0;
            int charsAtleastK = 0;

            while(r<s.length()){

                if(unique<=i){

                    int index = c[r]-'a';
                    if(arr[index]==0){
                        unique++;
                    }

                    arr[index]++;

                    if(arr[index]==k){
                        charsAtleastK++;
                    }

                    r++;

                }else{

                    int index = c[l]-'a';
                    if(arr[index]==k){
                        charsAtleastK--;
                    }

                    arr[index]--;

                    if(arr[index]==0)
                        unique--;

                    l++;
                }

                if(unique==i && unique ==charsAtleastK)
                    max = Math.max(max, r-l);
            }
        }
        return max;
    }


    public int getMaxUniqueChar(String s){

        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        return map.size();
    }


    public int longestSubstringDivide(String s, int k, int start, int end){

        if(k>end)
            return 0;

        int[] arr = new int[26];
        for(int i=start; i<end;i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i = start ; i<end; i++){

            if(arr[s.charAt(i)-'a']>=k)
                continue;

            int next = i+1;
            while(next<end && arr[s.charAt(next)-'a']<k)
                next++;

            return Math.max(longestSubstringDivide(s,k,start,i),
                    longestSubstringDivide(s,k,next,end));
        }

        return end-start;

    }
}
