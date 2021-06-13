package hard;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int n = words.length;

        for(int i=0; i<n; i++){
            StringBuilder s = new StringBuilder(words[i]);
            s.reverse();
            map.put(s.toString(), i);
        }


        if(map.containsKey("")){
            int blankIndex = map.get("");
            for(int i=0; i<n;i++){
                if(i!=blankIndex && isPalindrome(words[i]))
                    ans.add(Arrays.asList(i,blankIndex));
            }
        }


        for(int i=0;i<n;i++){
            String s = words[i];
            String left = new String();
            String right = new String();

            for(int j=0; j<s.length(); j++){
                left = s.substring(0,j+1);
                right = s.substring(j+1);

                System.out.println(left + " " + right);
                if(map.containsKey(left) && map.get(left)!=i && isPalindrome(right))
                    ans.add(Arrays.asList(i,map.get(left)));

                if(map.containsKey(right) && map.get(right)!=i && isPalindrome(left))
                    ans.add(Arrays.asList(map.get(right),i));
            }

        }

        return ans;


    }

    public boolean isPalindrome(String s){
        return isPalindrome(s,0, s.length()-1);
    }

    public boolean isPalindrome(String s, int l , int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }
}
