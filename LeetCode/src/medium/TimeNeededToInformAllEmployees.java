package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        ArrayList<Integer>[] empArr = new ArrayList[n];

        for(int i=0; i<n;i++){
            empArr[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){

            int m = manager[i];
            if(m!=-1)
                empArr[m].add(i);
        }

        return maxTime(headID, informTime, empArr);
    }


    public int maxTime(int head, int[] informTime, ArrayList[] empArr){

        int time = 0;
        ArrayList<Integer> sub = empArr[head];

        for(int i : sub){
            time = Math.max(time, maxTime(i,informTime,empArr));
        }

        return time + informTime[head];
    }


    public int numOfMinutesBFS(int n, int headID, int[] manager, int[] informTime) {

        ArrayList<Integer>[] empArr = new ArrayList[n];

        for(int i=0; i<n;i++){
            empArr[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            int m = manager[i];
            if(m!=-1)
                empArr[m].add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{headID,0});

        int ans = 0;
        while(!q.isEmpty()){
            int[] a = q.poll();
            int m = a[0];
            int t = a[1];

            ans = Math.max(ans,t);
            for(int i: empArr[m]){
                q.offer(new int[]{i, t+informTime[m]});
            }
        }

        return ans;

    }
}
