package medium;

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {

        int flips = 0;
        int ones = 0;
        for(char c: s.toCharArray()){

            if(c=='1'){
                ones++;
            }else{
                flips++;
                flips = Math.min(flips,ones);
            }
        }

        return flips;
    }


    public int minFlipsMonoIncrRec(String s) {

        int n = s.length();
        int[] zerosAhead = new int[n];

        for(int i=n-2;i>=0;i--){
            zerosAhead[i] = zerosAhead[i+1];
            if(s.charAt(i+1)=='0')
                zerosAhead[i]++;
        }

        Integer[] dp = new Integer[n];
        return minFlips(s,0,zerosAhead,dp);

    }


    public int minFlips(String s,int pos, int[] zeros, Integer[] dp){

        if(pos==s.length())
            return 0;

        if(dp[pos]!=null)
            return dp[pos];

        int minFlips = 100001;
        if(s.charAt(pos)=='0'){

            minFlips = Math.min(minFlips,1+zeros[pos]);
            minFlips = Math.min(minFlips,minFlips(s,pos+1,zeros,dp));
        }else{

            minFlips = Math.min(minFlips, zeros[pos]);
            minFlips = Math.min(minFlips, 1+ minFlips(s,pos+1,zeros,dp));
        }

        dp[pos]=minFlips;
        return minFlips;
    }
}
