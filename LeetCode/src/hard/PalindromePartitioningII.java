package hard;

public class PalindromePartitioningII {

    public int minCut(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        Integer[] cuts = new Integer[n];

        //return minCuts(s,0,dp, cuts) -1;
        return minCutsBottomUp(s,dp,cuts);

    }


    public int minCuts(String s, int i, boolean[][] dp, Integer[] cuts){

        if(i>=s.length())
            return 0;

        if(cuts[i]!=null)
            return cuts[i];

        int min = s.length()+1;

        for(int j=i; j<s.length(); j++){

            int m = 0;
            if( (s.charAt(i)==s.charAt(j))  && ( j - i <= 2 || dp[i+1][j-1] )){
                dp[i][j] = true;

                m = 1 + minCuts(s,j+1,dp,cuts);
                min = Math.min(min,m);
            }
        }

        cuts[i] = min;
        return min;
    }



    public int minCutsBottomUp(String s, boolean[][] dp,Integer[] cuts){

        int n = s.length();

        for(int i =0; i<n; i++){

            int min = i;
            for(int j=0; j<=i;j++){

                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1])){
                    dp[j][i] = true;

                    if(j==0){
                        min = 0;
                    }else{
                        min = Math.min(min,1+cuts[j-1]);
                    }
                }
            }

            cuts[i] = min;
        }

        return cuts[n-1];

    }
}
