package medium;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = 0;
        int[][] dp = new int[rows+1][cols+1];

        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1;j>=0; j--){

                if(matrix[i][j]=='1'){
                    dp[i][j] = 1+ Math.min( Math.min(dp[i+1][j],dp[i][j+1]) ,dp[i+1][j+1]);
                    max = Math.max(max,dp[i][j]);
                }
            }
        }

        return max*max;

    }

    public int maximalSquare1D(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = 0;
        int[] dp = new int[cols+1];
        int prev = 0;

        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1;j>=0; j--){
                int temp = dp[j];
                if(matrix[i][j]=='1'){
                    dp[j] = 1+ Math.min( Math.min(dp[j+1],dp[j]) ,prev);
                    max = Math.max(max,dp[j]);
                }else{
                    dp[j]=0;
                }
                prev = temp;
            }
        }

        return max*max;

    }

    public int maximalSquareBruteForce(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSq = 0;

        for(int i=0; i<rows;i++){
            for(int j=0; j<cols;j++){

                if(matrix[i][j]=='1'){

                    int sq = 1;
                    boolean flag = true;

                    while(i+sq<rows && j+sq<cols && flag){

                        for(int k=j;k<=sq+j;k++){
                            if(matrix[i+sq][k]=='0'){
                                flag = false;
                                break;
                            }
                        }

                        for(int k=i;k<=i+sq;k++){
                            if(matrix[k][j+sq]=='0'){
                                flag = false;
                                break;
                            }
                        }

                        if(flag)
                            sq++;
                    }

                    maxSq = Math.max(maxSq,sq);
                }
            }
        }
        return maxSq*maxSq;
    }
}
