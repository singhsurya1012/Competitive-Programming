package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class WEIRDO {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int numberOfRecipes = sc.nextInt();

            double numberOfRecipesByAlice = 0;
            double numberOfRecipesByBob = 0;

            double[] totalOccurrenceCountForAlice = new double[26];
            double[] totalOccurrenceCountForBob = new double[26];
            double[] uniqueRecipeCountForAlice = new double[26];
            double[] uniqueRecipeCountForBob = new double[26];


            while (numberOfRecipes-- > 0) {

                String recipe = sc.next();
                double[] totalOccurrenceCount = new double[26];

                for (char c : recipe.toCharArray()) {
                    totalOccurrenceCount[c - 'a']++;
                }


                if (recipeBelongsToAlice(recipe)) {

                    numberOfRecipesByAlice++;
                    for (int i = 0; i < 26; i++) {
                        totalOccurrenceCountForAlice[i] += totalOccurrenceCount[i];
                        if (totalOccurrenceCount[i] != 0) {
                            uniqueRecipeCountForAlice[i]++;
                        }
                    }

                } else {

                    numberOfRecipesByBob++;

                    for (int i = 0; i < 26; i++) {
                        totalOccurrenceCountForBob[i] += totalOccurrenceCount[i];
                        if (totalOccurrenceCount[i] != 0) {
                            uniqueRecipeCountForBob[i]++;
                        }
                    }


                }
            }

            double ratio = calculateFinalScore(totalOccurrenceCountForAlice, totalOccurrenceCountForBob, uniqueRecipeCountForAlice, uniqueRecipeCountForBob, numberOfRecipesByAlice, numberOfRecipesByBob);

            if (ratio > 10000000 || ratio == Double.NEGATIVE_INFINITY || ratio == Double.POSITIVE_INFINITY || Double.isInfinite(ratio) || Double.isNaN(ratio))
                writer.println("Infinity");
            else
                writer.println(ratio);

        }
    }

    private static double calculateFinalScore(double[] totalOccurrenceCountForAlice, double[] totalOccurrenceCountForBob, double[] uniqueRecipeCountForAlice, double[] uniqueRecipeCountForBob, double numberOfRecipesByAlice, double numberOfRecipesByBob) {

        double ratio = 0;
        double xa = 0;
        double xb = 0;
        double fa = 0;
        double fb = 0;

        for (int i = 0; i < 26; i++) {

            if (uniqueRecipeCountForAlice[i] != 0) {
                xa += Math.log(uniqueRecipeCountForAlice[i]);
                fa += Math.log(totalOccurrenceCountForAlice[i]);
            }
            if (uniqueRecipeCountForBob[i] != 0) {
                xb += Math.log(uniqueRecipeCountForBob[i]);
                fb += Math.log(totalOccurrenceCountForBob[i]);
            }

        }

        fa = fa * numberOfRecipesByAlice;
        fb = fb * numberOfRecipesByBob;

        ratio = xa - xb + fb - fa;
        ratio = Math.exp(ratio);
        return ratio;
    }

    private static boolean recipeBelongsToAlice(String recipe) {

        if (recipe.length() == 2) {

            if (checkIfVowel(recipe.charAt(0)) || checkIfVowel(recipe.charAt(1)))
                return true;
            return false;
        }

        for (int i = 1; i < recipe.length() - 1; i++) {

            int count = 0;
            if (!checkIfVowel(recipe.charAt(i - 1)))
                count++;

            if (!checkIfVowel(recipe.charAt(i)))
                count++;

            if (!checkIfVowel(recipe.charAt(i + 1)))
                count++;

            if (count >= 2)
                return false;

        }

        return true;

    }

    private static boolean checkIfVowel(char c) {

        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }


}
