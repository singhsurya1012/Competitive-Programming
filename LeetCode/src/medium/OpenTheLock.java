package medium;

import java.util.*;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {

        //Creating a hashset to check if its a dead in constant time
        Set<String> deadEnds = new HashSet<>(Arrays.asList(deadends));

        //Classic BFS problem where me move from one step in all the direction
        //Creating a hashset to track visited combination
        Set<String> visited = new HashSet<>();

        //Add the initial combination and marking it visited
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        if (deadEnds.contains("0000")) {
            return -1;
        }

        //Keeping track of the moves from the initial stage
        int moves = 0;

        while (!q.isEmpty()) {

            //Take only the combinations present at this stage
            int size = q.size();
            for (int j = 1; j <= size; j++) {

                String curr = q.poll();

                //If the stage matches the combinations return the moves needed
                if (curr.equals(target))
                    return moves;


                //Increment and decrement each position of the current combination
                //Each combination will result in 8 possible
                for (int i = 0; i < 4; i++) {

                    char c = curr.charAt(i);
                    String inc = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1);
                    String dec = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i + 1);

                    //Check if its not a dead end and not already visited
                    if (!visited.contains(inc) && !deadEnds.contains(inc)) {
                        q.offer(inc);

                        //Imp:: Mark it as already visited so that its not added by any other combination again
                        //Don't wait for this to be picked from queue to mark it
                        visited.add(inc);

                    }

                    if (!visited.contains(dec) && !deadEnds.contains(dec)) {
                        q.offer(dec);
                        visited.add(dec);
                    }
                }

            }

            moves++;

        }

        return -1;

    }
}
