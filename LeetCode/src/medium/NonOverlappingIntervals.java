package medium;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        if(n==1)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];

        int overlaps = 0;

        for(int i=1;i<n;i++){

            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start>=lastEnd){
                lastStart = start;
                lastEnd = end;
            }else {
                if(end<=lastEnd){
                    lastStart = start;
                    lastEnd = end;
                }

                overlaps++;
            }
        }

        return overlaps;
    }
}
