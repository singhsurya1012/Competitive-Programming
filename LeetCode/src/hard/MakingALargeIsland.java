package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        Integer[][] visited = new Integer[n][n];
        Map<Integer,Integer> areaMap = new HashMap<>();
        int maxArea = calculateArea(grid,areaMap,visited);

        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==0){

                    Set<Integer> connectedIslands = new HashSet<>();
                    for(int[] d: dir){
                        int x = i+d[0];
                        int y = j+d[1];

                        if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==1){
                            connectedIslands.add(visited[x][y]);
                        }
                    }
                    int area = 1;
                    for(int island: connectedIslands){
                        area+=areaMap.get(island);
                    }

                    maxArea = Math.max(maxArea,area);
                }
            }
        }


        return maxArea;

    }

    public int calculateArea(int[][] grid, Map<Integer,Integer> areaMap,Integer[][] visited){

        int n = grid.length;

        int index = 1;
        int maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==1 && visited[i][j]==null){
                    visited[i][j] = index;

                    int area = findArea(grid,visited, i, j, n);

                    areaMap.put(index,area);
                    index++;
                    maxArea = Math.max(area,maxArea);
                }
            }
        }

        return maxArea;

    }


    public int findArea(int[][] grid, Integer[][] visited, int i, int j, int n){

        int area = 1;

        for(int[] d: dir){

            int x = i+d[0];
            int y = j+d[1];

            if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==1 && visited[x][y]==null){
                visited[x][y] = visited[i][j];
                area+=findArea(grid,visited,x,y,n);
            }

        }

        return area;
    }
}
