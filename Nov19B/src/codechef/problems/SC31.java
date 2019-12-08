package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class SC31 {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int N = sc.nextInt();

            int finalValue = 0;

            while (N-- > 0) {

                int participant = sc.nextInt(2);
                finalValue = finalValue ^ participant;
            }

            int noOfWeaponsLeft = countSetBits(finalValue);
            writer.println(noOfWeaponsLeft);
        }
    }

    /***
     * subtracting 1 from any number  flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit.
     * so when we & it with thr original number the rightmost set bit becomes 0
     * @param n
     * @return
     */
    private static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

}
