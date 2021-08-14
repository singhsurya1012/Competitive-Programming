package hard;

public class RemoveBoxes {

    public int removeBoxes(int[] boxes) {

        int n = boxes.length;
        Integer[][][] dp = new Integer[n][n][n];
        return removeBoxes(boxes,0,n-1,0,dp);
    }


    public int removeBoxes(int[] boxes, int i, int j, int k, Integer[][][] dp){

        if(i>j)
            return 0;

        if(dp[i][j][k]!=null)
            return dp[i][j][k];

        if(i==j){
            dp[i][j][k] = (k+1)*(k+1);
            return dp[i][j][k];
        }

        int initial_i = i;
        int initial_k = k;

        //optimization
        while(i+1<=j && boxes[i+1]==boxes[i]){
            i++;
            k++;
        }

        int result = (k+1)*(k+1) + removeBoxes(boxes, i+1,j,0,dp);

        for(int m = i+1; m<=j;m++){

            if(boxes[i]==boxes[m]){
                result = Math.max(result, removeBoxes(boxes,i+1,m-1,0,dp) + removeBoxes(boxes,m,j,k+1,dp));
            }
        }

        dp[initial_i][j][initial_k] = result;
        return dp[initial_i][j][initial_k];
    }
}
