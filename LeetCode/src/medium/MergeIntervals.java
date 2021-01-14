package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> ans = new ArrayList<>();

        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {

            int x = intervals[i][0];
            int y = intervals[i][1];

            if (x > lastEnd) {
                int[] arr = new int[]{lastStart, lastEnd};
                ans.add(arr);

                lastStart = x;
                lastEnd = y;
            } else if (y > lastEnd) {
                lastEnd = y;
            }
        }

        int[] arr = new int[]{lastStart, lastEnd};
        ans.add(arr);

        return  ans.toArray(new int[ans.size()][2]);
    }
}
