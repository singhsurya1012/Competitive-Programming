package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MSNG {

    private static long threshold = (long) Math.pow(10, 12);

    private static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {

            int N = sc.nextInt();

            Set<Long> allPossibleValues = new TreeSet<>();

            int base = sc.nextInt();
            String value = sc.next();

            findValues(allPossibleValues, base, value);

            for (int j = 2; j <= N; j++) {

                base = sc.nextInt();
                value = sc.next();

                Set<Long> possibleValues = new TreeSet<>();

                if (allPossibleValues.size() > 0) {
                    findValues(possibleValues, base, value);
                    allPossibleValues.retainAll(possibleValues);
                }

            }

            if (allPossibleValues.size() > 0) {
                writer.println(allPossibleValues.iterator().next());
            } else {
                writer.println(-1);
            }

        }

    }

    private static void findValues(Set<Long> allPossibleValues, int base, String value) {
        try {
            if (base == -1) {
                allPossibleValues.addAll(addAllPossibleDecimalValues(value));
            } else {
                long decimalValue = Long.parseLong(value, base);
                if (decimalValue >= 0 && decimalValue <= threshold)
                    allPossibleValues.add(decimalValue);
            }
        } catch (Exception e) {

        }
    }

    private static Set<Long> addAllPossibleDecimalValues(String value) {

        Set<Long> possibleValues = new TreeSet<>();

        for (int i = 36; i >= 2; i--) {

            try {
                long convertedValue = Long.parseLong(value, i);

                if (convertedValue >= 0 && convertedValue <= threshold)
                    possibleValues.add(convertedValue);

            } catch (Exception e) {

            }

        }

        return possibleValues;
    }


}
