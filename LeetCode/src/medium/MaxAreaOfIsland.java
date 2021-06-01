package medium;

public class MaxAreaOfIsland {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){

                if(grid[i][j]==1){
                    int area = visitIsland(grid,i,j,m,n);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }

        return maxArea;

    }


    public int visitIsland(int[][] grid, int i, int j, int m, int n){
        grid[i][j] = 0;
        int area = 1;

        for(int[] d: dir ){

            int x = i+d[0];
            int y = j+d[1];

            if(isSafe(x,y,m,n) && grid[x][y]==1){
                area+= visitIsland(grid,x,y,m,n);
            }
        }

        return area;
    }


    public boolean isSafe(int x, int y, int m, int n){
        return x>=0 & y>=0 && x<m && y<n;
    }
}
