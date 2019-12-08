package codechef.problems;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class HRDSEQ {


    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        int[] sequence = new int[129];
        sequence[0] = 0;

        Map<Integer, LinkedList<Integer>> occurenceMap = new HashMap<>();

        int seqConstructedTill = 0;

        while (testCases-- > 0) {

            int N = sc.nextInt();
            if (N > seqConstructedTill) {
                constructSeq(sequence, seqConstructedTill, N, occurenceMap);
                seqConstructedTill = N;
            }

            int valueToBeSearched = sequence[N];

            int numberOfOccurence = calculateNumberOfOccurence(occurenceMap, N, valueToBeSearched);
            writer.println(numberOfOccurence);
        }
    }


    private static void constructSeq(int[] sequence, int seqConstructedTill, int N, Map<Integer, LinkedList<Integer>> occurenceMap) {

        for (int i = seqConstructedTill + 1; i <= N; i++) {

            int lastValue = sequence[i - 1];

            if (!occurenceMap.containsKey(lastValue)) {

                sequence[i] = 0;
                LinkedList<Integer> occurenceList = new LinkedList<>();
                occurenceList.add(i);
                occurenceMap.put(0, occurenceList);

            } else if (occurenceMap.get(lastValue).size() <= 1) {

                sequence[i] = 0;
                LinkedList<Integer> occurenceList = occurenceMap.get(0);
                occurenceList.addFirst(i);
                occurenceMap.put(0, occurenceList);

            } else {

                LinkedList<Integer> occurenceList = occurenceMap.get(lastValue);
                int l = i - 1;
                int k = occurenceList.get(1);
                sequence[i] = l - k;

                if (occurenceMap.containsKey(l - k)) {
                    LinkedList<Integer> list = occurenceMap.get(l - k);
                    list.addFirst(i);
                    occurenceMap.put(l - k, list);
                } else {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(i);
                    occurenceMap.put(l - k, list);
                }
            }
        }

    }


    private static int calculateNumberOfOccurence(Map<Integer, LinkedList<Integer>> occurenceMap, int N, int valueToBeSearched) {

        int count = 0;
        for (Integer i : occurenceMap.get(valueToBeSearched)) {

            if (i <= N)
                count++;
        }

        return count;

    }
}
