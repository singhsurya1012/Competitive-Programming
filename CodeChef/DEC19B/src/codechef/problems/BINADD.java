package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class BINADD {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();


        while (testCases-- > 0) {


            String a = sc.next();
            String b = sc.next();


            if (b.equals("0")) {
                writer.println(0);
            } else if (a.equals("0")) {
                writer.println(1);
            } else {

                a = "0" + a;
                b = "0" + b;

                char[] bigArr = null;
                char[] smallArr = null;

                if (a.length() >= b.length()) {
                    bigArr = a.toCharArray();
                    smallArr = b.toCharArray();
                } else {
                    bigArr = b.toCharArray();
                    smallArr = a.toCharArray();
                }

                int maxIterations = 1;
                int currItr = 0;

                for (int i =  1; i <=smallArr.length; i++) {


                    char x = bigArr[bigArr.length-i];
                    char y = smallArr[smallArr.length-i];

                    if (x == '1' && y == '1') {
                        if (currItr == 0) {
                            currItr++;
                        } else {
                            currItr++;
                            maxIterations = Integer.max(currItr, maxIterations);
                            currItr = 1;
                        }
                    } else if (x == '0' && y == '0' && currItr != 0) {

                        currItr++;
                        maxIterations = Integer.max(currItr, maxIterations);
                        currItr = 0;

                    } else if (currItr != 0) {
                        currItr++;
                    }
                }


                if (currItr != 0) {

                    for (int i = bigArr.length - smallArr.length - 1; i >= 0; i--) {

                        if (bigArr[i] == '1') {
                            currItr++;
                        } else {
                            currItr++;
                            break;
                        }
                    }

                    maxIterations = Integer.max(currItr, maxIterations);
                }
                writer.println(maxIterations);
            }

        }


    }
}
