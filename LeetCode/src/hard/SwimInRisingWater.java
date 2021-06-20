package hard;

public class SwimInRisingWater {int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public int swimInWater(int[][] grid) {
        return swimBS(grid);
        //return swimPQ(grid);
    }


    public int swimPQ(int[][] grid){

        int n = grid.length;
        visited = new boolean[n][n];
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2]-b[2]);

        q.offer(new int[]{0,0, grid[0][0]});
        visited[0][0] = true;


        int ans = 0;
        while(!q.isEmpty()){

            int[] p = q.poll();
            ans = Math.max(ans, p[2]);

            if(p[0]==n-1 && p[1]==n-1)
                return ans;

            for(int[] d:dir){

                int x = p[0]+d[0];
                int y = p[1]+d[1];

                if(isSafe(x,y,n) && !visited[x][y]){
                    visited[x][y] = true;
                    q.offer(new int[]{x,y,grid[x][y]});
                }
            }
        }

        return ans;


    }


    public int swimBS(int[][] grid){

        int n = grid.length;
        int l = 0;
        int r = n*n-1;

        while(l<r){

            int m = (r+l)/2;
            visited = new boolean[n][n];

            if(grid[0][0]<=m && dfs(m,0,0,grid))
                r=m;
            else
                l = m+1;
        }

        return l;

    }


    public boolean dfs(int t, int i, int j, int[][] grid){

        int n = grid.length;
        if(i==n-1 && j==n-1)
            return true;

        visited[i][j] = true;

        for(int[] d: dir){

            int x = i+d[0];
            int y = j+d[1];

            if(isSafe(x,y,n) && !visited[x][y] && grid[x][y]<=t && dfs(t,x,y,grid))
                return true;
        }

        return false;
    }



    public boolean isSafe(int i , int j, int n){
        return i>=0 && i<n && j>=0 && j<n;
    }
}
