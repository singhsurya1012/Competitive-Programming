package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class ISBIAS {

    public static void solve(Scanner sc, PrintWriter writer) {

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] ratings = new int[N + 1];

        int[] increasing = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            ratings[i] = sc.nextInt();
        }

        int previous = ratings[1];
        for (int i = 2; i <= N - 1; i++) {

            int current = ratings[i];
            int next = ratings[i + 1];

            if ((current < previous && current < next) || (current > previous && current > next)) {
                increasing[i] = 1;
            }
            previous = current;
        }

        int[] pre = new int[N+1];

        pre[0] = 0;

        for(int i=1;i<=N;i++) {

            pre[i] = pre[i-1]+ increasing[i];
        }

        while (Q-- > 0) {

            int L = sc.nextInt()+1;
            int R = sc.nextInt()-1;

            int numOfInc = 0;


            if(L==R) {
                numOfInc = increasing[L];
            }else {
                numOfInc = pre[R] - pre[L-1];
            }


            /*for (int i = L + 1; i <= R - 1; i++) {

                if (increasing[i] == 1) {
                    numOfInc++;
                }

            }*/

            numOfInc++;

            if (numOfInc % 2 == 0)
                writer.println("YES");
            else
                writer.println("NO");


        }


    }
}
