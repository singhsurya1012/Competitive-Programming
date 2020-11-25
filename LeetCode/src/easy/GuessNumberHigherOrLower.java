package easy;

public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {

        int min = 1;
        int max = n;

        while(min<=max){

            int num = min+(max-min)/2;

            if(guess(num)==0){
                return num;
            }else if(guess(num) ==1){
                min = num+1;
            }else {
                max = num-1;
            }
        }

        return -1;

    }

    //Forward declaration of guess API.
    public int guess(int n) {
        return -1;
    }
}
