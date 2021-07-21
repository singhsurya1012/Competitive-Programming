package medium;

public class DecodeWays {

    public int numDecodings(String s) {

        if(s.charAt(0)=='0')
            return 0;

        int n = s.length();
        Integer[] dp = new Integer[n];

        //return decodeForward(s,0,dp);
        //return decodeBackWards(s, n-1, dp);
        return numDecodingsBottomUpForward(s);
    }

    public int decodeForward(String s, int pos, Integer[] dp){
        int n =s.length();
        if(pos==n)
            return 1;

        if(dp[pos]!=null)
            return dp[pos];

        char c = s.charAt(pos);
        int ans = 0;

        if(c =='0')
            return 0;

        ans+= decodeForward(s,pos+1,dp);

        if(pos<n-1 && c =='1'){
            ans+=decodeForward(s,pos+2,dp);
        }else if(pos<n-1 && c=='2' && s.charAt(pos+1)<='6'){
            ans+=decodeForward(s,pos+2,dp);
        }

        dp[pos]=ans;
        return ans;

    }

    public int numDecodingsBottomUpForward(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;

        for(int i=n-1; i>=0; i--){

            if(s.charAt(i)!='0'){
                dp[i] = dp[i+1];
                if(i<n-1 && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<='6'))
                    dp[i]+=dp[i+2];
            }
        }

        return dp[0];
    }


    public int decodeBackWards(String s, int pos, Integer[] dp){

        if(pos<0)
            return 1;

        if(dp[pos]!=null)
            return dp[pos];

        char c = s.charAt(pos);

        int ans = 0;
        if(c!='0')
            ans = decodeBackWards(s, pos-1, dp);

        if(pos>0 && s.charAt(pos-1)=='1'){
            ans += decodeBackWards(s,pos-2, dp);
        }else if(pos>0 && s.charAt(pos-1)=='2' && c<='6'){
            ans += decodeBackWards(s,pos-2, dp);
        }

        dp[pos] = ans;
        return ans;
    }
}
