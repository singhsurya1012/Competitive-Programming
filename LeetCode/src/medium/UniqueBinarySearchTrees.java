package medium;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

    //Trees[n] = number of unique trees with n nodes;
    //F(i,n) = number of trees with i as root;
    //Trees[n] = F(1,n) + F(2,n) + ...... F(n,n)
    //F(i,n) = Trees[i-1]*Trees[n-i];
    //Trees[n] = Trees[0]*Trees[n-1] + Trees[1]*Trees[n-2] + ....... Trees[n-1]*Trees[0];
    public int numTrees(int n) {
        if(n==1 || n==2)
            return n;

        int[] trees = new int[n+1];
        trees[0] = 1;
        trees[1] = 1;

        for(int i=2; i<=n;i++){
            for(int j=1;j<=i;j++){
                trees[i]+=trees[j-1]*trees[i-j];
            }
        }

        return trees[n];
    }


    public int numTreesCatalanNumber(int n) {

        if(n==1 || n==2)
            return n;

        Map<Integer,Integer> map  = new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        map.put(2,2);

        for(int i=3; i<=n;i++){
            int ans = 0;
            for(int j=0;j<=i-1;j++){
                int k = i-1-j;
                ans+=map.get(j)*map.get(k);
            }

            map.put(i,ans);
        }

        return map.get(n);
    }
}
