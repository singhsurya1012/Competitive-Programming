package hard;

import java.util.*;

public class RectangleAreaII {

    public int rectangleArea(int[][] rectangles) {

        int n = rectangles.length;
        Set<Integer> xC = new HashSet<>();
        Set<Integer> yC = new HashSet<>();

        for(int[] rec: rectangles){
            xC.add(rec[0]);
            yC.add(rec[1]);
            xC.add(rec[2]);
            yC.add(rec[3]);
        }

        Integer[] xArr = xC.toArray(new Integer[0]);
        Integer[] yArr = yC.toArray(new Integer[0]);

        Arrays.sort(xArr);
        Arrays.sort(yArr);

        Map<Integer,Integer> xMap = new HashMap<>();
        for(int i=0; i<xArr.length;i++)
            xMap.put(xArr[i],i);

        Map<Integer,Integer> yMap = new HashMap<>();
        for(int i=0; i<yArr.length; i++)
            yMap.put(yArr[i],i);

        boolean[][] grid = new boolean[xArr.length][yArr.length];
        long ans = 0;

        for(int [] rec: rectangles){

            for(int x= xMap.get(rec[0]); x<xMap.get(rec[2]); x++) {
                for(int y= yMap.get(rec[1]); y<yMap.get(rec[3]); y++){

                    if(!grid[x][y]){
                        grid[x][y] = true;
                        ans += (long) (xArr[x+1]-xArr[x])*(yArr[y+1] - yArr[y]);
                    }
                }
            }

        }
        ans = ans%1000000007;
        return (int) ans;
    }
}
