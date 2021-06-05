package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {

    int mod = 1000000007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        List<Engineer> list = new ArrayList<>();

        for(int i=0; i<n;i++){
            list.add(new Engineer(speed[i],efficiency[i]));
        }

        list.sort((Engineer e1, Engineer e2) ->e2.eff-e1.eff);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        long speedSum = 0l;
        long maxPerformance = 0l;

        for(Engineer e : list){
            int eff = e.eff;
            int s = e.speed;

            if(queue.size()==k){
                speedSum -=queue.remove();
            }
            queue.add(e.speed);
            speedSum +=s;

            maxPerformance = Math.max(maxPerformance, speedSum * eff);
        }

        return (int)(maxPerformance%mod);
    }

    public long perf(long speed, int eff){
        long perf = speed*eff;
        return  perf%mod;
    }

    class Engineer {
        int speed;
        int eff;

        public Engineer(int speed, int eff){
            this.speed = speed;
            this.eff = eff;
        }
    }
}
