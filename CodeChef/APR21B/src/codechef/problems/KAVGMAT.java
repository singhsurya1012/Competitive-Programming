package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class KAVGMAT {

    public static void solve(Scanner sc, PrintWriter writer) {

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[][] matrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            long[][] sum = new long[n][m];

            calculateSum(sum, matrix, n, m);

            long ans = 0l;

            for (int size = 0; size < n; size++) {
                for (int i = 0; i < n - size; i++) {

                    int index = binarySearch(sum, i, m - size, size, k);
                    ans += m - size - index;
                }
            }
            writer.println(ans);
        }
    }

    private static int binarySearch(long[][] sum, int row, int col, int size, int k) {

        int left = 0;
        int right = col;

        while (left < right) {

            int mid = left + (right - left) / 2;

            double avg = calculateAverage(row + size, mid + size, row, mid, sum);

            if (avg < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static double calculateAverage(int x, int y, int i, int j, long[][] sum) {

        double total = sum[x][y];

        if (i > 0) {
            total -= sum[i - 1][y];
        }

        if (j > 0) {
            total -= sum[x][j - 1];
        }

        if (i > 0 && j > 0) {
            total += sum[i - 1][j - 1];
        }

        long elements = (x - i + 1) * (y - j + 1);
        return total / elements;
    }

    private static void calculateSum(long[][] sum, int[][] matrix, int n, int m) {

        for (int i = 0; i < m; i++) {
            sum[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j] = matrix[i][j] + sum[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = sum[i][j] + sum[i][j - 1];
            }
        }
    }


}
