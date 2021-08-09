package medium;

import java.util.HashMap;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        if((numerator>0)^(denominator>0)){
            sb.append("-");
        }

        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);


        //Integral part;
        sb.append(n/d);
        n = n%d;

        if(n==0){
            return sb.toString();
        }

        //fractional part
        sb.append(".");

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(n, sb.length());

        while(n!=0){
            n = n*10;
            sb.append(n/d);
            n = n%d;

            if(map.containsKey(n)){
                int index = map.get(n);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else {
                map.put(n, sb.length());
            }
        }

        return sb.toString();
    }
}
