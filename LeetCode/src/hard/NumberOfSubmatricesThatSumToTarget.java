package hard;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] sum = new int[m][n];
        fillSum(matrix,sum,m,n);
        int count  = 0;

        for(int r1=0; r1<m; r1++){
            for(int r2=r1; r2<m;r2++){

                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int s = 0;

                for(int c=0; c<n;c++){
                    s+=findSum(sum,r1,c,r2,c);
                    if(map.containsKey(s-target)){
                        count+=map.get(s-target);
                    }

                    map.put(s,map.getOrDefault(s,0)+1);
                }
            }
        }

        return count;

    }

    public int numSubmatrixSumTargetSlow(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] sum = new int[m][n];
        fillSum(matrix,sum,m,n);
        int count  = 0;

        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){

                for(int k= i;k<m;k++){
                    for(int l=j;l<n;l++){

                        if(findSum(sum, i,j, k, l)==target){
                            count++;
                        }
                    }
                }
            }
        }

        return count;

    }

    public int findSum(int[][] sum , int x1, int y1, int x2, int y2){

        int s = sum[x2][y2];

        if(x1>0) {
            s-=sum[x1-1][y2];
        }

        if(y1>0){
            s-=sum[x2][y1-1];
        }

        if(x1>0 && y1>0){
            s+=sum[x1-1][y1-1];
        }

        return s;
    }

    public void fillSum(int[][] matrix, int[][] sum, int m, int n){

        for(int i=0;i<n;i++){
            sum[0][i] = matrix[0][i];
        }

        for(int i=1; i<m;i++){
            for(int j=0; j<n;j++){
                sum[i][j] = sum[i-1][j] + matrix[i][j];
            }
        }

        for(int i=0; i<m;i++){
            for(int j=1; j<n;j++){
                sum[i][j] = sum[i][j-1] + sum[i][j];
            }
        }

    }

}
