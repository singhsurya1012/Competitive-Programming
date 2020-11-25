package medium;

public class Pow {

    public double myPow(double x, int n) {

        if(n==0){
            return 1;
        }

        //For negative n 1/myPow(x,-n) will give Integer overflow
        //Since -INT_MIN is greater than INT_MAX
        double p = myPow(x,n/2);
        if(n%2==0){
            return p*p;
        }else{

            if(n>0){
                return x*p*p;
            }else{
                return p*p/x;
            }
        }


    }
}
