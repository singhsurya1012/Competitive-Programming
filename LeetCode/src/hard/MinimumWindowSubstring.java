package hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }


        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int req = map.size();

        int l = 0;
        int r = 0;

        Map<Character, Integer> windowMap = new HashMap<Character, Integer>();

        int formed = 0;

        int left = 0;
        int right = 0;
        int len = -1;

        while(r<s.length()) {

            char c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c,0)+1);

            if(map.containsKey(c) &&  map.get(c).intValue()==windowMap.get(c).intValue()){
                formed++;
            }

            while(l<=r && formed==req){

                if(len==-1 || r-l+1<len){
                    right = r;
                    left = l;
                    len = right-left+1;
                }

                c = s.charAt(l);

                windowMap.put(c, windowMap.get(c)-1);

                if(map.containsKey(c) &&  map.get(c).intValue()>windowMap.get(c).intValue()){
                    formed--;
                }

                l++;

            }

            r++;

        }

        if(len==-1)
            return "";
        else
            return s.substring(left, right+1);
    }
}
