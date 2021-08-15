package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new LinkedList<>();
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        //first and last row
        for(int i=0; i<n;i++){
            flow(heights,0,i, pacific, -1);
            flow(heights,m-1,i, atlantic, -1);
        }

        //first and last col
        for(int i=0; i<m; i++){
            flow(heights,i,0,pacific,-1);
            flow(heights,i,n-1,atlantic,-1);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }

    public void flow(int[][] heights, int i, int j, boolean[][] river, int h){

        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length ||
                river[i][j] || heights[i][j]<h)
            return;

        river[i][j] = true;

        for(int[] d: dir){
            flow(heights, i+d[0],j+d[1], river, heights[i][j]);
        }
    }
}
