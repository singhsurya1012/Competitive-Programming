package easy;

public class PlusOne {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int[] plusOne(int[] digits) {
        //check if all the number are nine
        boolean allNine = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                allNine = false;
                break;
            }
        }

        int[] nextNum = null;

        if (allNine) {
            //If all nine increase the array length by one and return next num
            nextNum = new int[digits.length + 1];
            nextNum[0] = 1;
            return nextNum;

        } else {

            //Initial Number to be added
            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {

                //If after adding value is 10, set carry to 1 again and store 0 in array
                if (digits[i] + carry == 10) {
                    digits[i] = 0;
                } else {
                    //If after adding value is less than 10, set that value and break
                    digits[i] += carry;
                    break;
                }
            }
            return digits;
        }
    }
}
