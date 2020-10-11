import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrictlyIncreasingSequence {

    public static String whoIsTheWinner(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int uniqueElements = 0;


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueElements++;
            }
        }

        int duplicateElements = arr.size() - uniqueElements;

        if (duplicateElements == 0) {
            return "First";
        }

        boolean firstTurn = uniqueElements % 2 == 0;

        if (duplicateElements % 2 == 0) {
            return firstTurn ? "Second" : "First";
        } else {
            return firstTurn ? "First" : "Second";
        }
    }
}
