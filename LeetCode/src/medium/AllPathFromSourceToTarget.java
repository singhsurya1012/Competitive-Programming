package medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);

        dfs(graph, 0,graph.length-1, list,result);
        return result;
    }

    public void dfs(int[][] graph, int start, int end, List<Integer> list, List<List<Integer>> result){

        if(start==end){
            result.add(new ArrayList<>(list));
            return;
        }
        int[] neighbors = graph[start];
        for(int neighbor: neighbors){
            list.add(neighbor);
            dfs(graph,neighbor,end,list,result);
            list.remove(list.size()-1);
        }

    }
}
