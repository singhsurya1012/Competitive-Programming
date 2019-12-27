package codechef.problems;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class SUBSPLAY {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {


            int N = sc.nextInt();

            char[] charArr = sc.next().toCharArray();


            int[] lastCharIndexArr = new int[26];
            int[] minDistanceArr = new int[26];


            for(int i=0; i<charArr.length;i++) {

                int c = charArr[i] - 'a';

                if(lastCharIndexArr[c]==0) {
                    lastCharIndexArr[c] = i+1;
                }else {
                    int lastIndex = lastCharIndexArr[c];
                    int currIndex = i+1;
                    int dis = currIndex-lastIndex;
                    lastCharIndexArr[c] =currIndex;

                    if(minDistanceArr[c]==0) {
                        minDistanceArr[c] = dis;
                    }else {
                        minDistanceArr[c] = Integer.min(minDistanceArr[c],dis);
                    }
                }
            }

            OptionalInt minDistance = Arrays.stream(minDistanceArr).filter(value -> value!=0).min();

            writer.println(N-minDistance.orElse(N));
        }

    }
}
