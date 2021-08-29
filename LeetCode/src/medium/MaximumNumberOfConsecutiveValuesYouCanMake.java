package medium;

import java.util.Arrays;

public class MaximumNumberOfConsecutiveValuesYouCanMake {

    public int getMaximumConsecutive(int[] coins) {

        Arrays.sort(coins);
        int sum = 0;
        int n = coins.length;

        for (int coin : coins) {

            if (sum + 1 >= coin) {
                sum += coin;
            } else {
                return sum + 1;
            }
        }

        return sum + 1;
    }

}
