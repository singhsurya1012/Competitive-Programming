package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        int n = points.length;
        int l = 0;
        int r = n-1;

        while(l<=r){
            int p = partition(points,l,r);
            if(p==K)
                break;

            if(p<K)
                l=p+1;
            else
                r = p-1;
        }

        return Arrays.copyOfRange(points,0,K);
    }

    private int partition(int[][] p, int l, int r) {
        int[] pivot = p[r];
        int d = pivot[0]*pivot[0] + pivot[1]*pivot[1];

        int i = l;
        for(int j=l;j<r;j++){

            if(p[j][0]*p[j][0] + p[j][1]*p[j][1] <= d){
                swap(p, i,j);
                i++;
            }
        }

        swap(p,i,r);
        return i;
    }

    public void swap(int[][] p, int i, int j){
        int[] temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    public int[][] kClosestPriorityQueue(int[][] points, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->  (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] +a[1]*a[1]));

        for(int[] p :  points){

            queue.offer(p);

            if(queue.size()>k)
                queue.poll();
        }

        int[][] result = new int[k][2];
        int index = 0;
        while(!queue.isEmpty()){
            result[index++] = queue.poll();
        }

        return result;
    }
}
