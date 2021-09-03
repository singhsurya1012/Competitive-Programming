package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class ErectTheFence {

    public int[][] outerTrees(int[][] trees) {

        int n = trees.length;
        Arrays.sort(trees, (a, b) -> {

            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });

        Stack<int[]> hull = new Stack<>();

        for(int i=0; i<n;i++) {

            while(hull.size()>=2 && orientation(hull.get(hull.size()-2), hull.get(hull.size()-1), trees[i]) >0 ) {
                hull.pop();
            }
            hull.push(trees[i]);
        }

        hull.pop();

        for(int i=n-1;i>=0;i--){
            while(hull.size()>=2 && orientation(hull.get(hull.size()-2), hull.get(hull.size()-1), trees[i]) >0 ) {
                hull.pop();
            }
            hull.push(trees[i]);
        }

        HashSet<int[]> ret = new HashSet<>(hull);
        return ret.toArray(new int[ret.size()][]);

    }

    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }
}
