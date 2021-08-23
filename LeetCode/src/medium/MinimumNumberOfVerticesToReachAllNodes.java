package medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] degree = new int[n];
        for(List<Integer> edge: edges){
            degree[edge.get(1)]++;
        }
        List<Integer> vertex = new ArrayList<>();

        for(int i=0; i<n;i++){
            if(degree[i]==0){
                vertex.add(i);
            }
        }

        return vertex;

    }
}
