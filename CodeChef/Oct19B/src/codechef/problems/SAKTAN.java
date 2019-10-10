package codechef.problems;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SAKTAN {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] rowArr = new int[N+1];
            int[] colArr = new int[M+1];


            int queries = sc.nextInt();

            while (queries-- > 0) {
                rowArr[sc.nextInt()]++;
                colArr[sc.nextInt()]++;
            }

            long oddValues = calcuateOddValuesFromMap(rowArr, colArr);
            writer.println(oddValues);
        }

        writer.flush();
    }

    private static long calcuateOddValuesFromMap(int[] rowArr, int[] columnArr) {
        long oddRowValues = 0;
        long evenRowValues = 0;

        long oddColValues = 0;
        long evenColValues = 0;

        for(int i=1;i<rowArr.length;i++) {

            if(rowArr[i]%2!=0) {
                oddRowValues++;
            }else {
                evenRowValues++;
            }
        }

        for(int i=1;i<columnArr.length;i++) {

            if(columnArr[i]%2!=0) {
                oddColValues++;
            }else {
                evenColValues++;
            }
        }

        return oddRowValues*evenColValues + evenRowValues*oddColValues;
    }
}
