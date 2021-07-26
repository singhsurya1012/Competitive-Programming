package medium;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        for (int i = 0; i < n; ) {

            if (gas[i] < cost[i]) {
                i++;
            } else {

                int t = isPossibleToTravel(i, gas, cost);
                if (t == i) {
                    return i;
                } else if (t < i) {
                    return -1;
                } else {
                    i = t;
                }
            }
        }
        return -1;
    }


    public int isPossibleToTravel(int src, int[] gas, int[] cost) {
        int n = cost.length;
        int des = (src == 0) ? n - 1 : src - 1;


        int tank = gas[src] - cost[src];
        int curr = (src + 1) % n;

        while (curr != src) {
            if (gas[curr] + tank >= cost[curr]) {
                tank = tank + gas[curr] - cost[curr];
                curr = (curr + 1) % n;
            } else {
                return curr;
            }
        }

        return curr;
    }


    public int canCompleteCircuitClean(int[] gas, int[] cost) {

        int n = gas.length;
        for (int i = 0; i < n; ) {

            if (gas[i] < cost[i]) {
                i++;
            } else {

                int tank = gas[i] - cost[i];
                int start = i;

                i = (i + 1) % n;

                while (i != start) {

                    if (tank + gas[i] >= cost[i]) {
                        tank += gas[i] - cost[i];
                        i = (i + 1) % n;
                    } else {
                        tank = 0;
                        break;
                    }
                }

                if (i == start) {
                    return start;
                } else if (i < start) {
                    return -1;
                }
            }
        }
        return -1;
    }
}
