package codechef.problems;

import java.io.*;
import java.util.*;

public class CAMC {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            List<Box> boxes = new ArrayList<>(N);

            Map<Integer, List<Box>> sameColourBoxMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                Box b = new Box(sc.nextInt(), i % M);
                boxes.add(b);
            }

            Collections.sort(boxes, (o1, o2) -> {

                if (o1.numberOfBalls == o2.numberOfBalls)
                    return o1.boxNumber - o2.boxNumber;
                return o1.numberOfBalls - o2.numberOfBalls;
            });


            if (M == N) {

                writer.println(boxes.get(N - 1).numberOfBalls - boxes.get(0).numberOfBalls);

            } else {

                int minDiff = Integer.MAX_VALUE;
                int minIndex = 0;
                int maxIndex = 0;

                for (int i = 0; i < N; ) {

                    Box b = boxes.get(i);
                    if (sameColourBoxMap.containsKey(b.boxNumber)) {
                        sameColourBoxMap.get(b.boxNumber).add(b);
                    } else {
                        List<Box> boxList = new LinkedList<>();
                        boxList.add(b);
                        sameColourBoxMap.put(b.boxNumber, boxList);
                    }

                    maxIndex = i;
                    i++;

                    while (sameColourBoxMap.size() == M) {

                        int minBalls = boxes.get(minIndex).numberOfBalls;
                        int maxBalls = boxes.get(maxIndex).numberOfBalls;
                        int diff = maxBalls - minBalls;
                        minDiff = Integer.min(diff, minDiff);

                        removeFromMap(boxes.get(minIndex),sameColourBoxMap);
                        minIndex++;

                    }

                }

                writer.println(minDiff);

            }
        }


    }

    private static void removeFromMap(Box b, Map<Integer, List<Box>> sameColourBoxMap) {

        List<Box> boxList = sameColourBoxMap.get(b.boxNumber);
        boxList.remove(0);

        if (boxList.size() == 0) {
            sameColourBoxMap.remove(b.boxNumber);
        }
    }


    static class Box {

        int numberOfBalls;
        int boxNumber;

        public Box(int numberOfBalls, int boxNumber) {
            this.numberOfBalls = numberOfBalls;
            this.boxNumber = boxNumber;
        }
    }
}
