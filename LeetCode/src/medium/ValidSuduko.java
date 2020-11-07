package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSuduko {

    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<Integer, Set<Integer>> box = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            col.put(i, new HashSet<Integer>());
            box.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < 9; i++) {

            //Create a set for row
            Set<Integer> row = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                char c = board[i][j];

                if (c == '.')
                    continue;

                int s = (int) c;

                //Check if we have seen this num in current row
                if (row.contains(s))
                    return false;
                row.add(s);

                //Check col map and see if we have seen this number in col
                if (col.get(j).contains(s))
                    return false;
                col.get(j).add(s);

                //Calculate box index
                int boxIndex = (i / 3) * 3 + j / 3;
                //Check if we have seen this number in box
                if (box.get(boxIndex).contains(s))
                    return false;
                box.get(boxIndex).add(s);

            }
        }

        return true;
    }
}
