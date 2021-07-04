package easy;

public class FindCentreOfStarGraph {

    public int findCenter(int[][] edges) {

        int a1 = edges[0][0];
        int b1 = edges[0][1];

        int a2 = edges[1][0];
        int b2 = edges[1][1];

        if(a2==a1 || a2==b1)
            return a2;

        return b2;

    }

    public int findCenterSlow(int[][] edges) {

        int n = edges.length+1;
        int[] arr = new int[n+1];
        for(int[] t : edges){
            arr[t[0]]++;
            arr[t[1]]++;
        }

        for(int i=1;i<=n; i++){

            if(arr[i]==n-1)
                return i;
        }

        return -1;

    }
}
