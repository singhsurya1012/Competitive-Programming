package codechef.problems;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MSNG {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int noOfQueries = sc.nextInt();

            Set<Long> decimalNumberSet = new TreeSet<>();
            Set<String> inputs = new HashSet<>();

            while (noOfQueries-- > 0) {

                int base = sc.nextInt();
                String value = sc.next();

                if (base != -1) {
                    long decimalValue = toDecimal(value, base);
                    long maxAllowed = 1000000000000l;

                    if (decimalValue <= maxAllowed) {
                        decimalNumberSet.add(toDecimal(value, base));
                    }

                } else {
                    inputs.add(value);
                }
            }

            if (decimalNumberSet.size() == 0) {
                writer.println(-1);
            } else if (decimalNumberSet.size() == 1) {

                long decimalValue = decimalNumberSet.iterator().next();

                long value = checkIfConversionPossible(decimalValue, inputs);
                writer.println(value);
            } else {
                int x = 6 / 0;
                writer.println(-1);
            }

        }

        writer.flush();
    }

    private static long checkIfConversionPossible(long decimalValue, Set<String> inputs) {

        int radix = 36;
        radix = (int) Long.min(radix, decimalValue);
        while (radix > 1) {

            String convertedValue = fromDecimal(radix, decimalValue);
            inputs.remove(convertedValue);

            if (inputs.size() == 0) {
                return decimalValue;
            }
            radix--;
        }

        if (inputs.size() != 0)
            return -1;

        return decimalValue;
    }


    private static int val(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }


    private static long toDecimal(String str, int base) {
        int len = str.length();
        long power = 1;
        long num = 0;


        for (int i = len - 1; i >= 0; i--) {


            if (val(str.charAt(i)) >= base) {
                return -1;
            }

            num += val(str.charAt(i)) * power;
            power = power * base;
        }

        return num;
    }

    static char reVal(long num) {
        if (num >= 0 && num <= 9)
            return (char) (num + 48);
        else
            return (char) (num - 10 + 65);
    }

    static String fromDecimal(int base1, long inputNum) {
        String s = "";

        while (inputNum > 0) {
            s += reVal(inputNum % base1);
            inputNum /= base1;
        }
        StringBuilder ix = new StringBuilder();

        ix.append(s);

        return new String(ix.reverse());
    }
}
