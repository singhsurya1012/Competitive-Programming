package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class BRKBKS {

    public static void solve(Scanner sc, PrintWriter writer) {


        int testCases = sc.nextInt();


        while (testCases-- > 0) {

            int s = sc.nextInt();

            int w1 = sc.nextInt();
            int w2 = sc.nextInt();
            int w3 = sc.nextInt();


            if (s >= (w1 + w2 + w3)) {
                writer.println(1);
            } else if (s >= (w1 + w2) || s >= (w3 + w2)) {
                writer.println(2);
            } else {
                writer.println(3);
            }

        }
    }
}
