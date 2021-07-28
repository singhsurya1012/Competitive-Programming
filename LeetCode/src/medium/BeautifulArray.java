package medium;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {

    public int[] beautifulArray(int n) {
        int[] arr = new int[n];
        Map<Integer,int[]> cache = new HashMap<>();

        return beautifulArray(n,cache);
    }

    public int[] beautifulArray(int n, Map<Integer,int[]> cache){

        if(cache.containsKey(n))
            return cache.get(n);

        int[] ans = new int[n];

        if(n==1){
            ans[0]=1;
            return ans;
        }

        int[] odd = beautifulArray((n+1)/2, cache);
        int[] even = beautifulArray(n/2,cache);

        int index = 0;
        for(int i : odd){
            ans[index++] = 2*i-1;
        }

        for(int i: even){
            ans[index++] = 2*i;
        }

        cache.put(n,ans);

        return ans;

    }
}
