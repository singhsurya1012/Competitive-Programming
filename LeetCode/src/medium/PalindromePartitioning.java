package medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        findAllPalindrome(s,dp);

        partition(s,dp,0, new ArrayList<>());
        return result;
    }

    public void partition(String s, boolean[][] dp, int pos, List<String> list) {

        int n = s.length();
        if(pos==n){
            result.add(new ArrayList(list));
            return ;
        }


        for(int j=pos;j<n;j++){
            if(dp[pos][j]==true) {
                list.add(s.substring(pos,j+1));
                partition(s,dp,j+1, list);
                list.remove(list.size()-1);
            }

        }
    }


    public void findAllPalindrome(String s, boolean[][] dp){

        int n = s.length();

        for(int i=0; i<n;i++){
            dp[i][i] = true;
            if(i+1 < n && s.charAt(i)==s.charAt(i+1))
                dp[i][i+1] = true;
        }


        for(int len = 3; len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j = i+len-1;

                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
            }
        }
    }
}
