package codes;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int numberOfTestCase = in.nextInt();
        for (int i = 1; i <= numberOfTestCase; i++) {

            int numberOfGoods = in.nextInt();
            int totalValue = Arrays.stream(in.nextIntArray(numberOfGoods)).sum();
            int averageValue = (totalValue + numberOfGoods -1 )/ numberOfGoods;

            out.println(averageValue);

        }
    }

}
