package medium;

import java.util.*;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {

        int m = A.length;
        int n = B.length;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2]-b[2]);

        for(int i=0; i<A.length && i<k;i++){
            q.offer(new int[]{i,0,A[i]+B[0]});
        }

        List<List<Integer>> list = new ArrayList<>(k);


        while(list.size()<k && !q.isEmpty() ) {

            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];

            list.add(Arrays.asList(A[x],B[y]));

            if(y+1<n){
                q.offer(new int[]{x,y+1,A[x]+B[y+1]});
            }
        }
        return list;
    }


    public List<List<Integer>> kSmallestPairsSlow(int[] A, int[] B, int k) {

        int m = A.length;
        int n = B.length;

        PriorityQueue<int[]> q = new PriorityQueue<>(( a,b) -> {
            int val1 = A[a[0]] + B[a[1]];
            int val2 = A[b[0]] + B[b[1]];
            return val1-val2;
        });

        q.offer(new int[]{0,0});

        List<List<Integer>> list = new ArrayList<>(k);

        Set<String> set = new HashSet<>();
        set.add(0+":"+0);

        while(list.size()<k && !q.isEmpty() ) {

            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];


            list.add(Arrays.asList(A[x],B[y]));

            if(x+1<m && !set.contains((x+1) +":"+y)) {
                q.offer(new int[]{x+1,y});
                set.add((x+1) +":"+y);
            }

            if(y+1<n && !set.contains(x+":"+(y+1))) {
                q.offer(new int[]{x,y+1});
                set.add( x+":"+ (y+1) );
            }

        }

        return list;
    }
}
