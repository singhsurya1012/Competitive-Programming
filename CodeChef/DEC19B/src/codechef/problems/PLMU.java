package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class PLMU {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int N = sc.nextInt();

            int countOfTwo = 0;
            int countOfZero = 0;
            while (N-- > 0) {

                int x = sc.nextInt();

                if (x == 2)
                    countOfTwo++;
                else if (x == 0)
                    countOfZero++;


            }

            int pairs = (countOfTwo * (countOfTwo - 1)) / 2;
            pairs += (countOfZero * (countOfZero - 1)) / 2;

            writer.println(pairs);
        }
    }
}
