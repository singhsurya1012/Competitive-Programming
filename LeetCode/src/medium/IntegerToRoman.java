package medium;

import java.util.Map;

public class IntegerToRoman {

    Map<Integer, Character> map = Map.of(
            1, 'I', 5, 'V', 10, 'X', 50, 'L',
            100, 'C', 500, 'D', 1000, 'M');

    public String intToRoman(int num) {

        String s = new String();


        int tens = 1;

        //Iterate from the last digit
        //Can be modified to iterate from first digit
        while (num != 0) {

            int val = num % 10;
            num = num / 10;

            //get the Roman character corresponding to the digit
            s = getRomanLetter(val, tens) + s;
            tens = tens * 10;
        }

        return s;

    }


    public String getRomanLetter(int val, int tens) {

        StringBuilder sb = new StringBuilder();

        //Special case if the digit is 4 or 9
        //If its 4 then we need to its tens place value first and then the roman character correcponding to 5*tens place value
        //If its 9 then we need to its tens place value first and then the roman character correcponding to 10*tens place value
        if (val == 4) {
            char c = map.get(tens);
            sb.append(c);
            sb.append(map.get(tens * 5));
        } else if (val == 9) {
            char c = map.get(tens);
            sb.append(c);
            sb.append(map.get(tens * 10));
        } else if (val >= 5) {

            //If its greater than or equal to 5 we need to break into 2 parts
            //First the Roman character correspondintg to 5
            //Then recursively call to find the character for the remaining (val-5) value

            char c = map.get(tens * 5);
            sb.append(c);

            if (val - 5 != 0)
                sb.append(getRomanLetter(val - 5, tens));

        } else {

            //Else its simply less than 5 means we need to add the tens val number of times
            char c = map.get(tens);
            for (int i = 1; i <= val; i++) {
                sb.append(c);
            }
        }

        return sb.toString();

    }
}
