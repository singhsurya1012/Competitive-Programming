package easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {

        //Use Set to check for occurrence of loop
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            if (n == 1)
                return true;

            set.add(n);
            //Calculate the sum of squares of digits
            n = tryToBeHappy(n);
        }
        return false;
    }


    public int tryToBeHappy(int n) {
        int sum = 0;

        while (n != 0) {
            int a = n % 10;
            sum += a * a;
            n = n / 10;
        }
        return sum;
    }
}
