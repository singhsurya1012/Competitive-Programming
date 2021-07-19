package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagramsSlidingWindow(String s, String p) {

        List<Integer> result  = new LinkedList<>();

        if(p.length()>s.length())
            return result;

        Map<Character,Integer> map  = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int counter = map.size();

        int start = 0;
        int end = 0;

        while(end<s.length()){

            char c = s.charAt(end);

            if(map.containsKey(c)){

                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    counter--;

            }
            end++;

            while(counter==0){

                if(end-start==p.length()){
                    result.add(start);
                }

                c = s.charAt(start);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)>0)
                        counter++;
                }
                start++;
            }
        }
        return result;
    }



    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result  = new LinkedList<>();

        if(p.length()>s.length())
            return result;

        int[] pArr = new int[26];

        for(char c: p.toCharArray()){
            pArr[c-'a']++;
        }

        int[] sArr = new int[26];

        for(int i=0 ;i<p.length()-1;i++){
            char c = s.charAt(i);
            sArr[c-'a']++;
        }

        for(int i=p.length()-1; i<s.length();i++){
            char c = s.charAt(i);
            sArr[c-'a']++;

            if(isAnagram(pArr,sArr)){
                result.add(i-p.length()+1);
            }

            c = s.charAt(i-p.length()+1);
            sArr[c-'a']--;
        }

        return result;
    }

    public boolean isAnagram(int[] a, int[] b){

        for(int i=0;i<26;i++){
            if(a[i]!=b[i])
                return false;
        }

        return true;
    }
}
