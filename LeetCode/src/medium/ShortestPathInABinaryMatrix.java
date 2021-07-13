package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInABinaryMatrix {

    int[] dir = new int[]{-1,0,1};
    int n;
    boolean[][] visited;

    public int shortestPathBinaryMatrix(int[][] grid) {

        n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;

        visited = new boolean[n][n];
        //return path(grid,0,0);
        return pathBfs(grid);

    }

    public int pathBfs(int[][] grid){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int dis = 0;

        while(!q.isEmpty()){

            int size = q.size();
            dis++;

            while(size-->0){

                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];

                if(i==n-1 && j==n-1)
                    return dis;

                for(int X: dir){
                    for(int Y: dir){

                        int x = i+X;
                        int y = j+Y;

                        if(x==0 && y==0)
                            continue;

                        if(x<0 || x>=n || y<0 || y>=n || grid[x][y]==1 || visited[x][y])
                            continue;

                        visited[x][y] = true;
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
        return -1;

    }

    public int path(int[][] grid, int i, int j){

        if(i==n-1 && j==n-1)
            return 1;

        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]==1 || visited[i][j])
            return -1;

        visited[i][j] = true;

        int min  = Integer.MAX_VALUE;

        for(int X: dir){
            for(int Y: dir){

                int x = i+X;
                int y = j+Y;

                if(x==0 && y==0)
                    continue;

                int p = path(grid,x,y);

                if(p!=-1)
                    min = Math.min(min,p);
            }
        }

        visited[i][j] = false;

        if(min==Integer.MAX_VALUE)
            return -1;
        else
            return 1+min;
    }
}
