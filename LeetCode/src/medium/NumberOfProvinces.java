package medium;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;
        for(int i=0; i<n; i++){

            if(visited[i])
                continue;
            visited[i] = true;
            dfs(isConnected,i, visited);
            provinces++;
        }

        return provinces;
    }

    public void dfs(int[][] c, int start, boolean[] visited){

        int n = c.length;
        for(int i=0; i<n;i++){

            if(c[start][i]==1 && !visited[i]){
                visited[i] = true;
                dfs(c,i,visited);
            }
        }
    }
}
