package easy;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {

        if(n<=0)
            return false;

        if(n<1)
            return isPowerOfThree(1/n);

        if(n==1)
            return true;

        if(n%3!=0)
            return false;

        return isPowerOfThree(n/3);
    }

    public boolean isPowerOfThreeMaths(int n) {

        //For n = 3^x
        //Max value of n = INTEGER_MAX
        //So max Value of x = log(INTEGER_MAX)/log(3); = 19
        //so max value valid n = 3^19 = 1162261467
        //Only divisors of 3^19 are 3^0, 3^1, ...3^19
        return n > 0 && 1162261467 % n == 0;
    }
}
