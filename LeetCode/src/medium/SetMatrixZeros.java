package medium;

public class SetMatrixZeros {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean col = false;

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){

                if(matrix[i][j]==0){

                    matrix[i][0] = 0;
                    if(j==0){
                        col = true;
                    }else{
                        matrix[0][j] = 0;
                    }


                }
            }
        }


        for(int i=m-1;i>=0;i--){
            for(int j=n-1; j>=0; j--){
                if(j==0){
                    if(col){
                        matrix[i][j]=0;
                    }
                }else{
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }

            }
        }
    }


    public void setZeroesExtraSpace(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] col = new int[n];


        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(matrix[i][j]==0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }



        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(row[i]==-1 || col[j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }


    public void setZeroesBruteForce(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];


        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){

                if(!visited[i][j]){
                    if(matrix[i][j]==0){
                        fillZeros(matrix,i,j,m,n,visited);
                    }

                    visited[i][j] = true;
                }
            }
        }
    }


    public void fillZeros(int[][] matrix, int i, int j, int m , int n, boolean[][] visited){

        //Row
        for(int x=0; x<n;x++){

            if(matrix[i][x] != 0){
                matrix[i][x] = 0;
                visited[i][x] = true;
            }

        }
        //column
        for(int x=0; x<m;x++){
            if(matrix[x][j] != 0){
                matrix[x][j] = 0;
                visited[x][j] = true;
            }
        }
    }
}
