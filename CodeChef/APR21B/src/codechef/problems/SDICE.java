package codechef.problems;

import java.io.PrintWriter;
import java.util.Scanner;

public class SDICE {

    public static void solve(Scanner sc, PrintWriter writer) {

        int T = sc.nextInt();

        while(T-->0){

            long n = sc.nextLong();

            long x = n%4;
            long y = n/4;

            long pips = y*4*11;

            if(x==1){
                pips+=20;
            }else if(x==2){
                pips+=36;
            }else if(x==3){
                pips+=51;
            }

            if(y>0){
                pips+=(4-x)*4;
            }

            writer.println(pips);
        }
    }
}
