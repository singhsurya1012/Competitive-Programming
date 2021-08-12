package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){

            String k = sort(s);
            if(map.containsKey(k))
                map.get(k).add(s);
            else{
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(k,l);
            }
        }

        List<List<String>> list = new ArrayList<>();

        for(List<String> l: map.values()){
            list.add(l);
        }

        return list;

    }

    public String sort(String s){

        int[] arr = new int[26];

        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        /*for(int i= 0; i<arr.length; i++){
            for(int j=0; j<arr[i];j++){
                sb.append((char)(i+'a'));
            }
        }*/

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                sb.append(arr[i]);
                sb.append((char)(i+'a'));
            }
        }

        return sb.toString();
    }

}
