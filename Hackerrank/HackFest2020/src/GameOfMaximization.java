import java.util.List;

public class GameOfMaximization {

    public static int maximumStones(List<Integer> arr) {

        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < arr.size(); i++) {

            if (i % 2 == 0) {
                evenSum += arr.get(i);
            } else {
                oddSum += arr.get(i);
            }

        }

        return Integer.min(oddSum, evenSum) * 2;

    }
}
