package easy;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {

        if(num==1){
            return true;
        }
        int l = 1;
        int h = num/2;

        while(l<=h){

            int m = l + (h-l)/2;
            System.out.println(l+":"+m+":"+h);

            //m*m will cause overflow so instead compare m with num/m to check if its greater or less
            //For exact match we still need to check it with m*m since num/m will lose its decimal value
            if(m*m==num){
                return true;
            }else if(m<num/m){
                l=m+1;
            }else{
                h=m-1;
            }
        }

        return false;

    }
}
