package medium;

public class PalindromicSubstrings {

    int c = 0;

    public int countSubstrings(String s) {

        //return countBottomUp(s);
        return countExpandAroundCentre(s);
    }

    public int countBottomUp(String s) {

        int n = s.length();
        int count = 0;

        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n-1;i++){
            dp[i][i] = true;
            count++;

            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                count ++;
            }

        }

        dp[n-1][n-1] = true;
        count++;

        for(int i=3; i<=n;i++){
            for(int j=0; j<=n-i;j++){
                int k = i+j-1;
                if(s.charAt(j)==s.charAt(k) && dp[j+1][k-1]){
                    dp[j][k] =true;
                    count++;
                }
            }
        }

        return count;
    }

    public int countExpandAroundCentre(String s){

        int n = s.length();

        for(int i=0; i<n;i++){

            expand(s, i,i);
            expand(s,i,i+1);
        }

        return c;
    }


    public void expand(String s, int left, int right){

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            c++;
            left--;
            right++;
        }

    }
}
