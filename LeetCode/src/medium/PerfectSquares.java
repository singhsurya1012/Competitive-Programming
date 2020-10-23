package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {

    public int numSquares(int n) {

        double sqrt = Math.sqrt(n);

        //Check if the number is already a perfect square
        if (sqrt % 1 == 0) {
            return 1;
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();


        //Add all the initial possible squares smaller than number
        for (int i = 1; i <= Math.floor(sqrt); i++) {
            q.offer(i * i);
            visited.add(i * i);
        }


        int nums = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            //For each square
            for (int i = 0; i < size; i++) {

                int curr = q.poll();

                //If the value is equal return nums needed
                if (curr == n) {
                    return nums;
                }

                //Add next possible combinations by adding squares to current number
                for (int j = 1; j * j <= n - curr; j++) {

                    int x = curr + j * j;

                    if (!visited.contains(x)) {
                        q.offer(x);
                        visited.add(x);
                    }
                }

            }

            nums++;
        }

        return -1;
    }
}
