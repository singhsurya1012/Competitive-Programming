package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class WATSCORE {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int[] scores = new int[11];

            int N = sc.nextInt();

            while (N-- > 0) {

                int questionNum = sc.nextInt();
                int score = sc.nextInt();

                if (questionNum <= 8) {
                    scores[questionNum] = Integer.max(scores[questionNum], score);
                }

            }
            int totalScore = calculateTotalScore(scores);
            writer.println(totalScore);


        }
    }

    private static int calculateTotalScore(int[] scores) {

        int totalScore = 0;
        for (int i = 1; i <= 8; i++) {
            totalScore += scores[i];
        }
        return totalScore;
    }
}
