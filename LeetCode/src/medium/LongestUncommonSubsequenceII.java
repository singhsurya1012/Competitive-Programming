package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {

        int n = strs.length;
        Arrays.sort(strs, (a, b) -> b.length() -a.length());

        Map<String,Integer> map = new HashMap<>();
        for(String s: strs){
            map.put(s, map.getOrDefault(s,0)+1);
        }

        for(int i=0; i<n;i++){
            String s = strs[i];
            if(map.get(s)>1){
                continue;
            }

            boolean subSequence = false;
            for(int j=i-1;j>=0;j--){

                subSequence = isSubSequence(s,strs[j]);
                if(subSequence)
                    break;
            }

            if(!subSequence){
                return s.length();
            }
        }

        return -1;
    }


    public boolean isSubSequence(String sub, String s){

        int i =  0;
        int j = 0;

        while(j<sub.length() && i<s.length()){

            if(s.charAt(i)==sub.charAt(j)){
                j++;
            }

            i++;
        }

        return j==sub.length();
    }
}
