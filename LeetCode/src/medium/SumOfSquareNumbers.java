package medium;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {

        int min = 0;
        int max = (int) Math.sqrt(c);

        while(min<=max){

            if(min*min ==c -max*max)
                return true;

            int mid = min + (max-min)/2;

            if(min*min<c-max*max){

                if(mid*mid<c-max*max){
                    min = mid+1;
                }else{
                    min++;
                }

            }else{

                if(min*min>c-mid*mid){
                    max = mid-1;
                }else{
                    max--;
                }
            }
        }

        return false;
    }

    public boolean judgeSquareSumSlow(int c) {

        int min = 0;
        int max = (int) Math.sqrt(c);

        while(min<=max){

            long sum = min*min + max*max;

            if(sum==c){
                return true;
            }else if(sum>c){
                max--;
            }else{
                min++;
            }
        }

        return false;
    }
}
