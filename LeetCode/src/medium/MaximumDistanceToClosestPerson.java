package medium;

public class MaximumDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {

        int n = seats.length;
        int i = 0;

        int start = 0;
        int end = 0;
        int middle = 0;

        int curr = 0;

        //Fetching empty seats from the start;
        while (curr < n) {

            if (seats[curr] == 1)
                break;

            curr++;
        }

        start = curr;
        curr++;

        int k = 0;

        //middle empty seats
        while (curr < n) {
            if (seats[curr] == 1) {
                middle = Math.max(middle, k);
                k = 0;
            } else {
                k++;
            }

            curr++;
        }

        //end empty seats
        end = k;

        return Math.max(Math.max(start, end), (middle + 1) / 2);
    }


    public int maxDistToClosestTwoPointer(int[] seats) {

        int n = seats.length;
        int left = -1, right = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (seats[i] == 1) {
                left = i;
            } else {

                while (right < n && (seats[right] == 0 || right < i))
                    right++;

                int l = left == -1 ? n : i - left;
                int r = right == n ? n : right - i;

                ans = Math.max(ans, Math.min(l, r));
            }
        }

        return ans;

    }


    public int maxDistToClosestSlow(int[] seats) {

        int n = seats.length;
        int[] closestOne = new int[n];

        for (int i = 0; i < n; i++) {

            if (seats[i] == 0) {
                if (i != 0) {
                    closestOne[i] = 1 + closestOne[i - 1];
                } else {
                    closestOne[i] = 20001;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            if (seats[i] == 0) {
                if (i != n - 1) {
                    closestOne[i] = Math.min(closestOne[i], 1 + closestOne[i + 1]);
                } else {
                    closestOne[i] = Math.min(closestOne[i], 20001);
                }
            }
        }

        int maxDistance = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                maxDistance = Math.max(maxDistance, closestOne[i]);
            }
        }

        return maxDistance;
    }
}
