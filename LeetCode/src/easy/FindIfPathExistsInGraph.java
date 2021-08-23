package easy;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph {

    int[] parent;

    public boolean validPath(int n, int[][] edges, int start, int end) {

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return find(start) == find(end);
    }

    public void union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        parent[parentA] = parentB;

    }

    public int find(int a) {

        if (a != parent[a]) {
            parent[a] = find(parent[a]);
        }

        return parent[a];

    }

    public boolean validPathGraph(int n, int[][] edges, int start, int end) {

        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int des = edge[1];

            adjList[src].add(des);
            adjList[des].add(src);
        }
        boolean[] visited = new boolean[n];
        return dfs(adjList, start, end, visited);
    }

    public boolean dfs(ArrayList[] adjList, int start, int end, boolean[] visited) {

        if (start == end)
            return true;
        visited[start] = true;

        List<Integer> neighbors = adjList[start];
        for (Integer neighbor : neighbors) {

            if (!visited[neighbor] && dfs(adjList, neighbor, end, visited))
                return true;
        }

        return false;
    }
}
