package medium;

public class StringToInteger {

    public int myAtoi(String str) {

        if (str.isEmpty()) return 0;
        int n = str.length();

        int sign = 1, base = 0, i = 0;

        while (i < n && str.charAt(i) == ' ')
            i++;

        if (i >= n)
            return 0;

        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;


        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;

    }
}
