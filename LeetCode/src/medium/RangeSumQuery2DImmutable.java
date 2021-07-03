package medium;

public class RangeSumQuery2DImmutable {

    class NumMatrix {

        int m;
        int n;
        int[][] sum;

        public NumMatrix(int[][] matrix) {
            this.m = matrix.length;
            this.n = matrix[0].length;
            this.sum = matrix;
            fillMatrix();
        }

        private void fillMatrix(){

            for(int i=0; i<m;i++){
                for(int j=0; j<n; j++){

                    if(i>0)
                        sum[i][j] +=sum[i-1][j];

                    if(j>0)
                        sum[i][j]+=sum[i][j-1];

                    if(i>0 && j>0)
                        sum[i][j]-=sum[i-1][j-1];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int s = sum[row2][col2];

            if(row1>0)
                s-=sum[row1-1][col2];

            if(col1>0)
                s-=sum[row2][col1-1];

            if(row1>0 && col1>0)
                s+=sum[row1-1][col1-1];

            return s;
        }
    }
}
