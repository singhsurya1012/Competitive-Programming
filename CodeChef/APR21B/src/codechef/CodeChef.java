package codechef;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CodeChef {

    static class Range {

        int u;
        int v;
        int d;

        int s;

        public Range(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int[] arr = new int[]{-3,-4,3};
        //move(arr);

        moveMaintain(arr);

        for (int i : arr) {
            System.out.println(i);
        }

        //solve(sc, writer);
        writer.flush();
    }

    private static void moveMaintain(int[] arr) {

        int n = arr.length;
        int curr = 0;
        for(int i =0 ; i<n ;i++){

            if(arr[i]>=0){
                int val =arr[i];
                int j = i-1;

                while(j>=0 && arr[j]<0){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = val;
            }
        }

        for(int i=0; i<n;i++){
            if(arr[i]<0){
                arr[i] = 0;
            }
        }

    }

    private static void solve(Scanner sc, PrintWriter writer) {

        int T = sc.nextInt();

        String s = "";
        while (T-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                g[i] = sc.nextInt();
            }

            int[] prefix = new int[n];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + g[i];
            }

            List<Range> ranges = new ArrayList<>(m);

            while (m-- > 0) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                int d = sc.nextInt();

                if (d != 0) {
                    //int s = prefix[v] -prefix[u] + g[u];
                    //Range r = new Range();
                    //ranges.add();

                }
            }

            prefix[0] = g[0];


        }
    }

    static int remZero(String x) {

        if (x.length() == 0) {
            return 0;
        }

        if (x.charAt(0) == '0') {
            return 1 + remZero(x.substring(1));
        } else {
            System.out.print(x.charAt(0));
            return remZero(x.substring(1));
        }

    }


    static void move(int[] arr) {

        int p1 = 0;
        int p2 = arr.length - 1;

        while (p1 <= p2) {

            if (arr[p1] >= 0) {
                p1++;
            } else {
                arr[p1] = arr[p2];
                arr[p2] = 0;
                p2--;
            }
        }

    }


}
