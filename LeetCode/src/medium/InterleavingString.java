package medium;

public class InterleavingString {

    String[] arr = new String[2];

    public boolean isInterleave(String s1, String s2, String s3) {
        arr[0] = s1;
        arr[1] = s2;

        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }

       /* int[][][] dp = new int[s3.length()+1][s3.length()+1][2];
        return interleave(0, s3, 0, 0, dp) || interleave(0,s3,0,1, dp);*/

        int memo[][] = new int[s1.length()][s2.length()];
        return isInterleaveRec(s1,0,s2,0,s3,0, memo);
    }


    public boolean interleave(int x, String t, int i, int stringNum, int[][][] dp){


        if(x==t.length()){
            return true;
        }

        if(dp[x][i][stringNum]!=0){
            return 1==dp[x][i][stringNum];
        }

        String s = arr[stringNum];


        if(i>=s.length()){
            return false;
        }

        if(t.charAt(x)!=s.charAt(i)){
            return false;
        }


        int y = x - i;
        boolean ans = interleave(x+1,t,i+1,stringNum,dp) || interleave(x+1,t,y,(stringNum+1)%2, dp);
        if(ans){
            dp[x][i][stringNum] = 1;
        }else{
            dp[x][i][stringNum] = -1;
        }

        return ans;
    }


    public boolean isInterleaveRec(String s1, int i, String s2, int j, String s3, int k, int[][] memo){

        if(i==s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }

        if(j==s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }

        if(memo[i][j]!=0){
            return memo[i][j]==1;
        }

        boolean ans = false;

        if(s1.charAt(i)==s3.charAt(k) && isInterleaveRec(s1,i+1,s2,j,s3,k+1,memo)){
            ans = true;
        }else if(s2.charAt(j)==s3.charAt(k) && isInterleaveRec(s1,i,s2,j+1,s3,k+1,memo)){
            ans = true;
        }

        memo[i][j] = ans?1:-1;
        return ans;
    }

}

