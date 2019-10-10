package codechef.problems;

import java.io.PrintWriter;
import java.util.*;

public class MSV {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int N = sc.nextInt();
            int maxStarValue = 0;

            Map<Integer, List> factormap = new HashMap<>();

            for (int i = 0; i < N; i++) {

                int currVal = sc.nextInt();

                int starValue = factormap.get(currVal) == null ? 0 : factormap.get(currVal).size();
                uniqueDivisors(currVal, factormap);
                maxStarValue = Integer.max(starValue, maxStarValue);

            }

            writer.println(maxStarValue);

        }

        writer.flush();
    }

    private static void uniqueDivisors(int n, Map<Integer, List> factormap) {

        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                // If divisors are equal, print only one
                if (n / i != i) {

                    if (factormap.containsKey(n / i)) {
                        factormap.get(n / i).add(n);
                    } else {
                        List<Integer> factors = new LinkedList<>();
                        factors.add(n);
                        factormap.put(n / i, factors);
                    }

                }

                if (factormap.containsKey(i)) {
                    factormap.get(i).add(n);
                } else {
                    List<Integer> factors = new LinkedList<>();
                    factors.add(n);
                    factormap.put(i, factors);
                }
            }
        }
    }

}
