package medium;

public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";

        //return longestPalindromeDP(s);

        return longestPalindromeExpandAroundCentre(s);
    }


    public String longestPalindromeDP(String s){

        int n = s.length();
        char[] c = s.toCharArray();

        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLength = 1;

        for(int i=0;i<n-1;i++){
            dp[i][i] = true;

            if(c[i]==c[i+1]){
                dp[i][i+1]=true;
                start=i;
                maxLength=2;

            }
        }

        dp[n-1][n-1]=true;


        for(int k=3;k<=n;k++){

            for(int i=0; i<=n-k;i++){
                int j = i+k-1;

                if(c[i]==c[j] && dp[i+1][j-1]){
                    dp[i][j]=true;

                    if(k>maxLength){
                        maxLength=k;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start,start+maxLength);
    }


    public String longestPalindromeExpandAroundCentre(String s){

        int n = s.length();
        int start = 0;
        int end = 0;

        for(int i=0; i<n;i++){

            int lenOdd = expand(s, i,i);
            int lenEven = expand(s,i,i+1);

            int len = Math.max(lenOdd,lenEven);

            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }

        }

        return s.substring(start, end+1);
    }


    public int expand(String s, int left, int right){

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        //Incremented extra
        right--;
        left++;

        return right - left + 1;
    }


}
