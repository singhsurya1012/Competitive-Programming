package medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length==0)
            return new int[][]{newInterval};

        int n = intervals.length;

        List<int[]> ans = new ArrayList<>();

        int i = 0;
        boolean merged = false;
        int[] last = new int[2];

        if(newInterval[0]<intervals[0][0]){
            last[0] = newInterval[0];
            last[1] = newInterval[1];
            merged = true;
        }else{
            last[0] = intervals[0][0];
            last[1] = intervals[0][1];
            i++;
        }

        while(i<n){

            int[] curr = intervals[i];

            if(!merged && newInterval[0]<curr[0]){
                merged = true;
                curr = newInterval;
            }else{
                i++;
            }

            merge(ans, last, curr);

        }

        if(!merged){
            merge(ans,last,newInterval);
        }

        ans.add(new int[]{last[0],last[1]});
        return ans.toArray(new int[ans.size()][2]);
    }


    public void merge(List<int[]> ans, int[] last, int[] curr){

        if(curr[0]>last[1]){
            ans.add(new int[]{last[0],last[1]});
            /*last[0] = curr[0];
            last[1] = curr[1];*/
        }else if(curr[1]>last[1]){
            last[1] = curr[1];
        }
    }
}
