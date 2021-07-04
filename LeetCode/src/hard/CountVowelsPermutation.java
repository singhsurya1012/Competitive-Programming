package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountVowelsPermutation {

    int M = 1000000007;
    Map<Character, List<Character>> charMap;

    Map<Integer, List<Integer>> map;
    Integer[][] dp;

    public int countVowelPermutation(int n) {

        int aCount = 1;
        int eCount = 1;
        int iCount = 1;
        int oCount = 1;
        int uCount = 1;

        for(int x=2; x<=n;x++){

            int a = ((eCount+iCount)%M + uCount)%M;
            int e = (aCount+iCount)%M;
            int i = (eCount + oCount) % M;
            int o = iCount;
            int u = (iCount + oCount) % M;


            aCount = a;
            eCount = e;
            iCount = i;
            oCount = o;
            uCount = u;
        }

        int result = ((aCount+eCount)%M + (iCount+oCount)%M)%M;
        result = (result+uCount)%M;

        return result;

    }


    public int countVowelPermutationDP(int n) {

        int result = 0;


        dp = new Integer[5][n+1];

        map = new HashMap<>();
        map.put(0, Arrays.asList(1));
        map.put(1,Arrays.asList(0,2));
        map.put(2,Arrays.asList(0,1,3,4));
        map.put(3,Arrays.asList(2,4));
        map.put(4,Arrays.asList(0));

        result = (count(0, 1, n) + count(1, 1, n)) % M ;
        result = (result + count(2, 1, n))%M;
        result = (result + count(3, 1, n))%M;
        result = (result + count(4, 1, n))%M;

        return result;
    }


    public int count(int last, int pos, int n){

        if(pos==n)
            return 1;

        if(dp[last][pos]!=null)
            return dp[last][pos];

        int count = 0;

        for(Integer i: map.get(last)){
            count = (count + count(i,pos+1,n))%M;
        }

        dp[last][pos] = count;
        return count;


    }



    public int countVowelPermutationBruteForce(int n) {

        int result = 0;


        charMap = new HashMap<>();
        charMap.put('a', Arrays.asList('e'));
        charMap.put('e', Arrays.asList('a', 'i'));
        charMap.put('i', Arrays.asList('a', 'e', 'o', 'u'));
        charMap.put('o', Arrays.asList('i', 'u'));
        charMap.put('u', Arrays.asList('a'));

        result += count('a', 1, n);
        result += count('e', 1, n);
        result += count('i', 1, n);
        result += count('o', 1, n);
        result += count('u', 1, n);

        return result;
    }


    public int count(char last, int pos, int n) {

        if (pos == n)
            return 1;

        int count = 0;
        for (char c : charMap.get(last)) {
            count += count(c, pos + 1, n);
        }

        return count;


    }

}
