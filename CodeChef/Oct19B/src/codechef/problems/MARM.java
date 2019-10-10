package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class MARM {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int N = sc.nextInt();
            long K = sc.nextLong();

            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }

            modifyArray(array, N, K);
            printArray(writer, array);
        }

        writer.flush();
    }

    private static void modifyArray(int[] array, int N, long K) {

        if (K > 3 * N) {
            if (N % 2 != 0) {
                array[N / 2] = 0;
            }
        }

        int x = (int) (K % (N * 3));

        for (int i = 0; i < x; i++) {

            int a = array[i % N];
            int b = array[N - (i % N) - 1];
            array[i % N] = a ^ b;
        }

    }


    private static void printArray(PrintWriter wr, int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            wr.print(array[i] + " ");
        }
        wr.println(array[array.length - 1]);
    }
}
