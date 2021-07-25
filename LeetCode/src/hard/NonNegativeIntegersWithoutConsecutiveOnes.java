package hard;

public class NonNegativeIntegersWithoutConsecutiveOnes {

    public int findIntegers(int num) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;

        for (int i = 2; i < f.length; i++)
            f[i] = f[i - 1] + f[i - 2];

        int i =31, sum = 0, prevBit= 0;
        while(i>=0){

            if((num&(1<<i))!=0){

                sum+=f[i];
                if(prevBit==1){
                    sum--;
                    break;
                }
                prevBit=1;

            }else{
                prevBit = 0;
            }
            i--;
        }
        return sum+1;

    }

    public int findIntegersBruteForce(int n) {

        int count = 0;
        for(int i=0;i<=n;i++){

            if(check(i))
                count++;
        }
        return count;
    }

    public boolean check(int n){
        int i = 31;

        while(i>0){
            if( (n&(1<<i))!=0 && (n & (1<<(i-1)))!=0 )
                return false;
            i--;
        }
        return true;
    }
}
