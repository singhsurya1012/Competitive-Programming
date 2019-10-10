package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class SE10 {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();


        while (testCases-- > 0) {

            int arraySize = sc.nextInt();
            int[] priceArray = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                priceArray[i] = sc.nextInt();
            }

            int goodPrice = countGoodDays(arraySize, priceArray);
            writer.println(goodPrice);
        }

        writer.flush();
    }

    private static int countGoodDays(int arraySize, int[] priceArray) {
        int goodPrice = 1;

        for (int j = 1; j < arraySize; j++) {

            int currPrice = priceArray[j];
            int minPrice = Integer.MAX_VALUE;

            for (int k = j - 1; k >= 0 && k >= j - 5; k--) {

                if (currPrice >= priceArray[k]) {
                    minPrice = priceArray[k];
                    break;
                }

            }

            if(currPrice<minPrice) {
                goodPrice++;
            }

        }
        return goodPrice;
    }
}
