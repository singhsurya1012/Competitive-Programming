package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class MEXSTR {

    public static void solve(Scanner sc, PrintWriter writer) {

        int T = sc.nextInt();

        while (T-- > 0) {

            String str = sc.next();
            char[] arr = str.toCharArray();

            int n = str.length();

            int[] nextZero = new int[n];
            int[] nextOne = new int[n];

            fillNextArrays(arr, n, nextZero, nextOne);

            if (nextZero[0] == n) {
                writer.println("0");
                continue;
            }

            if (nextOne[0] == n) {
                writer.println("1");
                continue;
            }

            int[] dp = new int[n + 2];
            dp[n] = 0;
            dp[n+1] = 0;

            for (int i = n - 1; i >= 0; i--) {
                dp[i] = dp[i + 1];
                if (arr[i] == '0' && nextOne[i] < n) {
                    dp[i] = Math.max(dp[i], 1 + dp[nextOne[i] + 1]);
                } else if (arr[i] == '1' && nextZero[i] < n) {
                    dp[i] = Math.max(dp[i], 1+ dp[nextZero[i]+1]);
                }
            }

            int start = nextOne[0];
            int length = findPairs(str, nextOne[0])+2;

            StringBuilder sb = new StringBuilder();
            sb.append("1");

            int curr = start+1;
            for(int i=1; i<length;i++){

                if(curr>=n){
                    sb.append("0");
                    continue;
                }

                if(nextZero[curr]>=n){
                    sb.append("0");
                    curr = nextZero[curr]+1;
                    continue;
                }

                if(dp[nextZero[curr]+1] < length-1-i){
                    sb.append("0");
                    curr = nextZero[curr]+1;
                }else{
                    sb.append("1");
                    curr = nextOne[curr]+1;
                }
            }

            writer.println(sb.toString());
        }
    }

    private static void fillNextArrays(char[] arr, int n, int[] nextZero, int[] nextOne) {

        int last = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                for (int j = last + 1; j <= i; j++) {
                    nextZero[j] = i;
                }
                last = i;
            }
        }

        for (int i = last + 1; i < n; i++) {
            nextZero[i] = n;
        }

        last = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                for (int j = last + 1; j <= i; j++) {
                    nextOne[j] = i;
                }
                last = i;
            }
        }

        for (int i = last + 1; i < n; i++) {
            nextOne[i] = n;
        }
    }

    private static int findPairs(String str, int start) {
        int pairs = 0;
        for (int i = start+1; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                pairs++;
                i++;
            }
        }

        return pairs;
    }


}
