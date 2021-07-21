package medium;

public class CapacityToShipPackageWithinDDays {

    public int shipWithinDays(int[] weights, int days) {

        int min = 0;
        int max = 0;
        int sum = 0;

        for (int w : weights) {
            sum += w;
            min = Math.max(min, w);
        }

        min = Math.max(min, sum / days);
        max = sum;

        while (min < max) {

            int w = (min + max) / 2;

            if (isPossible(weights, days, w)) {
                max = w;
            } else {
                min = w + 1;
            }
        }

        return min;
    }

    public boolean isPossible(int[] weights, int days, int target) {

        int count = 0;
        int sum = 0;
        for (int w : weights) {

            if (sum + w <= target) {
                sum += w;
            } else {
                count++;
                sum = w;
            }
        }
        count++;

        if (count <= days)
            return true;
        return false;
    }
}
