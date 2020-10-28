package medium;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {

        int m = matrix.length;

        if(m==0){
            return new int[0];
        }
        int n = matrix[0].length;

        int[] arr = new int[m*n];
        int curr = 0;

        //Total Number of diagonals
        int diagonals = m+n-1;

        int i = 0;
        int j = 0;

        //We will alternately move up and down the diagonal starting from up
        boolean up = true;
        while(diagonals-->0) {

            if(up){
                up = false;
                arr[curr++] = matrix[i][j];

                while(i-1>=0 && i-1<m && j+1>=0 && j+1<n){
                    i = i-1;
                    j = j+1;
                    arr[curr++] = matrix[i][j];
                }

                //If We cant move diagonally up our next position is either right or down
                if(j+1>=0 && j+1<n){
                    j = j+1;
                }else{
                    i = i+1;
                }
            }else {

                up = true;
                arr[curr++] = matrix[i][j];
                while(i+1>=0 && i+1<m && j-1>=0 && j-1<n){
                    i = i+1;
                    j = j-1;
                    arr[curr++] = matrix[i][j];
                }

                //If We cant move diagonally down our next position is either down or right
                if(i+1>=0 && i+1<m){
                    i = i+1;
                }else{
                    j = j+1;
                }
            }
        }

        return arr;
    }
}
