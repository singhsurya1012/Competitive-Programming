package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class DYNAMO {

    public static void solve(Scanner sc, PrintWriter writer) {


        int testCases = sc.nextInt();


        while (testCases-- > 0) {

            int N = sc.nextInt();
            long maxPerf = (long) Math.pow(10, N);

            long A = sc.nextLong();

            long S = A + (2 * maxPerf);
            writer.println(S);
            writer.flush();

            long B = sc.nextLong();

            long C = maxPerf - B;
            writer.println(C);
            writer.flush();

            long D = sc.nextLong();

            long E = maxPerf - D;
            writer.println(E);
            writer.flush();

            int ans = sc.nextInt();

            if (ans == -1)
                break;

        }
    }
}
