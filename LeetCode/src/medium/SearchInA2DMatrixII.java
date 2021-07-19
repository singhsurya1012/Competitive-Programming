package medium;

public class SearchInA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int r = 0;
        int c = n-1;

        while(r<m && c>=0){

            if(matrix[r][c]==target)
                return true;

            if(target< matrix[r][c]){
                c--;
            }else{
                r++;
            }
        }

        return false;
    }
}
