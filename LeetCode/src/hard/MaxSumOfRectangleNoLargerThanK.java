package hard;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<rows;i++){
            for(int j=1;j<cols;j++){
                matrix[i][j] = matrix[i][j-1] + matrix[i][j];
            }
        }

        for(int i=0; i<cols;i++){
            for(int j=i;j<cols;j++){

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                int sum = 0;
                for(int r=0; r<rows; r++){

                    sum+=matrix[r][j];

                    if(i>0)
                        sum-=matrix[r][i-1];

                    Integer x = set.ceiling(sum-k);
                    if(x!=null){
                        ans = Math.max(ans, sum - x);
                    }
                    set.add(sum);

                    if(ans==k)
                        return ans;
                }
            }
        }

        return ans;

    }
}
