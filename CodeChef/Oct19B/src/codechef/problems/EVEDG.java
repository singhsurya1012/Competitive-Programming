package codechef.problems;

import java.io.PrintWriter;
import java.util.*;

public class EVEDG {

    public static void solve(Scanner sc, PrintWriter writer) {

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            StringBuilder sb = new StringBuilder();
            if (M % 2 == 0) {
                writer.println(1);
                while (M-- > 0) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();

                    while (N-- > 0) {
                        sb.append(1 + " ");
                    }
                }

                while (N-- > 0) {
                    sb.append(1 + " ");
                }

            } else {

                Map<Integer, Set<Integer>> vertexEdgeMap = new HashMap<>();

                Set<Integer> edgeSet = new HashSet<>();


                while (M-- > 0) {

                    int u = sc.nextInt();
                    int v = sc.nextInt();

                    addEdge(u, v, vertexEdgeMap, edgeSet);
                }

                if (edgeSet.size() != 0) {
                    int oddEdge = edgeSet.iterator().next();

                    writer.println(2);
                    for (int i = 1; i <= N; i++) {

                        if (i == oddEdge)
                            sb.append(2 + " ");
                        else
                            sb.append(1 + " ");
                    }

                } else {

                    writer.println(3);

                    Map.Entry<Integer, Set<Integer>> entry = vertexEdgeMap.entrySet().iterator().next();

                    int set1Value = entry.getKey();
                    int set2Value = entry.getValue().iterator().next();

                    for (int i = 1; i <= N; i++) {

                        if (i == set1Value) {
                            sb.append(1 + " ");
                        } else if (i == set2Value) {
                            sb.append(2 + " ");
                        } else {
                            sb.append(3 + " ");
                        }
                    }

                }

            }
            writer.print(sb.toString());
            writer.println();
        }
        writer.flush();
    }

    private static void addEdge(int u, int v, Map<Integer, Set<Integer>> vertexEdgeMap, Set<Integer> edgeSet) {

        if (vertexEdgeMap.containsKey(u)) {
            vertexEdgeMap.get(u).add(v);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(v);
            vertexEdgeMap.put(u, set);
        }

        if (vertexEdgeMap.containsKey(v)) {
            vertexEdgeMap.get(v).add(u);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(u);
            vertexEdgeMap.put(v, set);
        }


        if (edgeSet.contains(u)) {
            edgeSet.remove(u);
        } else {
            edgeSet.add(u);
        }

        if (edgeSet.contains(v)) {
            edgeSet.remove(v);
        } else {
            edgeSet.add(v);
        }
    }
}
