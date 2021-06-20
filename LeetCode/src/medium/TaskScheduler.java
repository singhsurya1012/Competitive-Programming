package medium;

import java.util.Arrays;

public class TaskScheduler {

    public int leastIntervalClean(char[] tasks, int n) {

        int[] t = new int[26];
        int max = 0;
        int maxCount = 0;

        for(char c: tasks){
            t[c-'A']++;

            if(max==t[c-'A']){
                maxCount++;
            }else if(t[c-'A']>max){
                max=t[c-'A'];
                maxCount = 1;
            }
        }

        int partCount = max-1;
        int emptySlots = partCount*(n - (maxCount-1));
        int remTasks = tasks.length-max*maxCount;
        int idleSlots = Math.max(0, emptySlots-remTasks);

        int totalTime = tasks.length+idleSlots;

        return totalTime;
    }


    public int leastInterval(char[] tasks, int n) {

        int[] t = new int[26];
        for(char c: tasks){
            t[c-'A']++;
        }

        Arrays.sort(t);

        int max  = 0;
        int time = 0;

        for(int i=t.length-1;i>=0;i--){

            if(max==0){
                max = t[i];
                time = (max-1)*(n+1) +1;
                continue;
            }

            if(t[i]==max)
                time++;
            else
                break;

        }

        return Math.max(tasks.length,time);
    }
}
