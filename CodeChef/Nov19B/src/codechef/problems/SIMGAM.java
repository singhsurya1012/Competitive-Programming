package codechef.problems;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SIMGAM {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int N = sc.nextInt();

            long chefValue = 0l;
            long ramsayValue = 0l;
            List<Integer> middleElements = new ArrayList<>();

            while (N-- > 0) {

                int numberOfCoins = sc.nextInt();

                if (numberOfCoins % 2 == 0) {

                    for (int i = 1; i <= numberOfCoins / 2; i++)
                        chefValue += sc.nextInt();

                    for (int i = numberOfCoins / 2 + 1; i <= numberOfCoins; i++)
                        ramsayValue += sc.nextInt();

                } else {

                    for (int i = 1; i <= numberOfCoins / 2; i++)
                        chefValue += sc.nextInt();

                    middleElements.add(sc.nextInt());

                    for (int i = numberOfCoins / 2 + 2; i <= numberOfCoins; i++)
                        ramsayValue += sc.nextInt();

                }

            }


            middleElements.sort(Collections.reverseOrder());

            for (int i = 0; i < middleElements.size(); i++) {

                if (i % 2 == 0)
                    chefValue += middleElements.get(i);
                else
                    ramsayValue += middleElements.get(i);
            }

            writer.println(chefValue);
        }

    }
}
