package codechef.problems;

import java.io.PrintWriter;
import java.util.*;

public class BINXOR {

    public static int mod = 1000000000 + 7;

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int N = sc.nextInt();

            char[] a = sc.next().toCharArray();
            char[] b = sc.next().toCharArray();

            int a1 = 0;
            int b1 = 0;

            for (int i = 0; i < N; i++) {

                if (a[i] == '1')
                    a1++;

                if (b[i] == '1') {
                    b1++;
                }
            }


            if (a1 < b1) {
                int c = a1;
                a1 = b1;
                b1 = c;
            }


            long combinations = 0;
            long actualComb = 0;
            Map<Integer, Long> dp = new HashMap<>();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i <= b1; i++) {

                int x = b1 - i;
                int y = i;
                if (a1 + x <= N) {
                    int noOfOne = a1 + x - y;
                    set.add(noOfOne);
                    actualComb += (calculateCombination(N, noOfOne, dp) % mod);
                }

            }
            writer.println("Actual : " + actualComb);

            if (set.size() <= N / 4) {
                for (Integer integer : set) {
                    combinations += (calculateCombination(N, integer, dp) % mod);
                }
            } else {

                int smallerNum = ((TreeSet<Integer>) set).first();
                int biggerNum = ((TreeSet<Integer>) set).last();
                long z = 0;

                if (biggerNum % 2 == 0) {

                    for (int i = 0; i < smallerNum; i += 2) {
                        z += (calculateCombination(N, i, dp) % mod);
                    }

                    for (int i = biggerNum + 2; i <= N; i += 2) {
                        z += (calculateCombination(N, i, dp) % mod);
                    }

                } else {

                    for (int i = 1; i < smallerNum; i += 2) {
                        z += (calculateCombination(N, i, dp) % mod);
                    }

                    for (int i = biggerNum + 2; i <= N; i += 2) {
                        z += (calculateCombination(N, i, dp) % mod);
                    }

                }

                combinations = ((pow(N - 1) % mod) - z) % mod;
            }


            writer.println(combinations % mod);


        }

    }


    private static long pow(int i) {
        if (i == 0)
            return 1;

        if (i == 1)
            return 2;


        if (i % 2 == 0)
            return (pow(i / 2) % mod) * (pow(i / 2 % mod));

        return 2 * (pow(i / 2) % mod) * (pow(i / 2 % mod));
    }

    private static long calculateCombination(int n, int r, Map<Integer, Long> dp) {

        int N = n;
        int R = r;
        if (dp.containsKey(r)) {
            return dp.get(r);
        } else if (dp.containsKey(n - r)) {
            return dp.get(n - r);
        } else {

            long p = 1, k = 1;

            if (n - r < r) {
                r = n - r;
            }


            if (r != 0) {
                while (r > 0) {
                    p *= n;
                    k *= r;

                    long m = gcd(p, k);

                    p /= m;
                    k /= m;

                    n--;
                    r--;
                }

            } else {
                p = 1;
            }

            dp.put(R, p);
            dp.put(N - R, p);
            return p;
        }

    }


    private static long gcd(long n1, long n2) {
        long gcd = 1;

        for (int i = 1; i <= n1 && i <= n2; ++i) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

}
