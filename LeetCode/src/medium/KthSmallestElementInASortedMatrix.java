package medium;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {


    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        if(k==1)
            return matrix[0][0];

        if(k==n*n)
            return matrix[n-1][n-1];


        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while(low<=high){

            int mid = low + (high-low)/2;
            int count = getCountLessThanEqual(matrix, mid);

            if(count<k)
                low=mid+1;
            else
                high=mid-1;

        }

        return low;
    }


    public int getCountLessThanEqual(int[][] matrix, int val){
        int n = matrix.length;
        int i = 0;
        int j = n-1;

        int count = 0;

        while(i<n && j>=0){

            if(matrix[i][j]>val){
                j--;
            }else{
                count+=j+1;
                i++;
            }
        }
        return count;
    }

    public int kthSmallestHeapSpaceOptimised(int[][] matrix, int k) {

        int n = matrix.length;

        if(k==1)
            return matrix[0][0];

        if(k==n*n)
            return matrix[n-1][n-1];


        PriorityQueue<Element> queue = new PriorityQueue<>(k, (e1,e2) -> e1.val-e2.val);

        for(int i=0; i<n && i<k ; i++){
            queue.offer( new Element(matrix[i][0],i,0));
        }


        while(k!=1){

            Element top = queue.poll();
            int i = top.i;
            int j = top.j;


            if(j<n-1)
                queue.offer(new Element(matrix[i][j+1],i,j+1));

            k--;
        }

        return queue.peek().val;


    }

    public int kthSmallestHeap(int[][] matrix, int k) {

        int n = matrix.length;

        if(k==1)
            return matrix[0][0];

        if(k==n*n)
            return matrix[n-1][n-1];

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Element> queue = new PriorityQueue<>(k, (e1, e2) -> e1.val-e2.val);
        queue.offer( new Element(matrix[0][0],0,0));

        visited[0][0] = true;

        while(k!=1){

            Element top = queue.poll();
            int i = top.i;
            int j = top.j;

            if(i<n-1 && !visited[i+1][j]){
                queue.offer(new Element(matrix[i+1][j],i+1,j));
                visited[i+1][j] = true;
            }


            if(j<n-1 && !visited[i][j+1]){
                queue.offer(new Element(matrix[i][j+1],i,j+1));
                visited[i][j+1] = true;

            }

            k--;
        }

        return queue.peek().val;


    }
}

class Element {

    int val;
    int i;
    int j;

    public Element(int val, int i, int j){
        this.val=val;
        this.i = i;
        this.j = j;
    }
}
