package medium;

import java.util.Arrays;

public class MatchsticksToSquare {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;
        int max = 0;
        for(int i:matchsticks){
            max = Math.max(max,i);
            sum+=i;
        }

        if(sum%4!=0 || max> sum/4){
            return false;
        }

        int len = sum/4;
        Arrays.sort(matchsticks);

        return checkIfPossible(matchsticks, matchsticks.length-1,0,0,0,0, len);
    }


    public boolean checkIfPossible(int[] m, int pos,int a, int b, int c, int d, int len){

        if(pos==-1){
            if(a==len && b==len && c==len && d==len)
                return true;
            return false;
        }

        if(a>len || b>len || c>len || d>len)
            return false;

        for(int i=pos; i>=0;i--){
            int l = m[pos];
            return (checkIfPossible(m, pos-1,a+l,b,c,d,len) || checkIfPossible(m, pos-1,a,b+l,c,d,len) ||  checkIfPossible(m, pos-1,a,b,c+l,d,len) || checkIfPossible(m, pos-1,a,b,c,d+l,len));
        }

        return false;
    }
}
