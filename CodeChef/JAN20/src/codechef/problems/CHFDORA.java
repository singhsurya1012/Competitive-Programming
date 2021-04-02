package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class CHFDORA {

    public static void solve(Scanner sc, PrintWriter writer) {


        int testCases = sc.nextInt();


        while (testCases-- > 0) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] matrix = new int[N][M];

            for (int i = 0; i < N; i++) {

                int[] row = new int[M];

                for (int j = 0; j < M; j++) {
                    row[j] = sc.nextInt();
                }

                matrix[i] = row;
            }

            long numberOfCombination = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    numberOfCombination += findCombinations(i, j, N, M, matrix);
                }
            }

            writer.println(numberOfCombination);
        }
    }

    private static long findCombinations(int i, int j, int N, int M, int[][] matrix) {

        int x = 1;

        while (isSafe(i, j - x, N, M) && isSafe(i, j + x, N, M)
                && isSafe(i - x, j, N, M) && isSafe(i + x, j, N, M)
                && (matrix[i][j - x] == matrix[i][j + x]) && (matrix[i - x][j] == matrix[i + x][j])) {

            x++;

        }

        return x;
    }

    private static boolean isSafe(int i, int j, int N, int M) {

        if (i >= 0 && j >= 0 && i < N && j < M) {
            return true;
        }
        return false;
    }
}
