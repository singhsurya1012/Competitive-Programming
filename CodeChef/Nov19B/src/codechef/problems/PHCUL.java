package codechef.problems;

import java.io.PrintWriter;
import java.util.*;

public class PHCUL {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            Point start = new Point(sc.nextInt(), sc.nextInt());

            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            List<Point> nPoints = new ArrayList<>(N);
            List<Point> mPoints = new ArrayList<>(M);
            List<Point> kPoints = new ArrayList<>(K);

            addPoints(sc, N, nPoints);
            addPoints(sc, M, mPoints);
            addPoints(sc, K, kPoints);

            calculateMinDistanceFromEnd(nPoints, kPoints);
            calculateMinDistanceFromEnd(mPoints, kPoints);

            double shortestDistance = Double.MAX_VALUE;
            shortestDistance = calculateShortestDistance(start, nPoints, mPoints, shortestDistance);
            shortestDistance = calculateShortestDistance(start, mPoints, nPoints, shortestDistance);

            writer.println(shortestDistance);

        }

    }

    private static void calculateMinDistanceFromEnd(List<Point> nPoints, List<Point> endPoints) {

        for (Point p : nPoints) {

            double distanceFromEnd = Double.MAX_VALUE;

            for (Point end : endPoints) {
                distanceFromEnd = Double.min(p.distance(end), distanceFromEnd);
            }

            p.minDistanceFromEnd = distanceFromEnd;
        }

    }

    private static double calculateShortestDistance(Point start, List<Point> firstStop, List<Point> secondStop, double shortestDistance) {

        for (Point first : firstStop) {

            double startToFirst = 0;

            if (first.distanceFromStart == 0) {
                startToFirst = start.distance(first);
                first.distanceFromStart = startToFirst;
            } else {
                startToFirst = first.distanceFromStart;
            }

            if (startToFirst > shortestDistance)
                continue;

            for (Point second : secondStop) {

                double firstToSecond = 0;

                if (second.distanceFromMiddle.containsKey(first)) {
                    firstToSecond = second.distanceFromMiddle.get(first);
                } else {
                    firstToSecond = first.distance(second);
                    second.distanceFromMiddle.put(first, firstToSecond);
                    first.distanceFromMiddle.put(second, firstToSecond);
                }

                if (firstToSecond > shortestDistance || startToFirst + firstToSecond > shortestDistance)
                    continue;

                double secondToLast = second.minDistanceFromEnd;

                double distance = startToFirst + firstToSecond + secondToLast;
                shortestDistance = Double.min(shortestDistance, distance);

            }

        }

        return shortestDistance;
    }

    private static void addPoints(Scanner sc, int n, List<Point> pointList) {
        for (int i = 1; i <= n; i++) {
            pointList.add(new Point(sc.nextLong(), sc.nextLong()));
        }
    }


    static class Point {

        long x;
        long y;
        double distanceFromStart;
        Map<Point, Double> distanceFromMiddle = new HashMap<>();
        double minDistanceFromEnd;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
            this.distanceFromStart = 0;
            this.minDistanceFromEnd = 0;
        }

        public double distance(Point p) {

            return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
