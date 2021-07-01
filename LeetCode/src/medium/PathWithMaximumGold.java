package medium;

public class PathWithMaximumGold {

    int m;
    int n;
    public int getMaximumGold(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int max = 0;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){

                if(grid[i][j]!=0){
                    max = Math.max(max, collect(grid, i,j));
                }

            }
        }

        return max;
    }


    public int collect(int[][] grid, int i, int j){


        if(i<0 || i>=m || j<0 || j>=n)
            return 0;


        if(grid[i][j]==0)
            return 0;

        int curr = grid[i][j];
        grid[i][j] = 0;

        int gold = 0;

        //moveRight
        gold = Math.max(gold, collect(grid, i,j+1));

        //moveDown
        gold = Math.max(gold, collect(grid, i+1,j));

        //moveLeft
        gold = Math.max(gold, collect(grid, i,j-1));

        //moveUp
        gold = Math.max(gold, collect(grid, i-1,j));

        grid[i][j] = curr;
        return curr+gold;

    }
}
