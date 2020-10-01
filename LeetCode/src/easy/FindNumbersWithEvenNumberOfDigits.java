package easy;


public class FindNumbersWithEvenNumberOfDigits {

    //Time Complexity : O(N*6)
    //Space Complexity : O(1)
    public int findNumbers(int[] nums) {
        int evenDigitNum = 0;
        for(int i: nums) {
            if(containsEvenDigits(i))
                evenDigitNum++;
        }
        return evenDigitNum;
    }


    public boolean containsEvenDigits(int num) {
        int digits = 0;

        while(num!=0) {
            //Everytime dividing by 10 reduces 1 digit
            num = num/10;
            digits++;
        }
        return digits%2==0;
    }
}
