package medium;

import java.util.HashMap;
import java.util.Map;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] arr) {

        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int start=0; start<n;start++){

            //already visited
            if(map.containsKey(start))
                continue;

            int curr = start;
            while(isValidCycle(start, curr, arr)){

                //marking current index visited
                map.put(curr,start);

                int jump = arr[curr]%n; //steps to jump;
                //Jumping x steps backwards is same as jumping (n-x) steps forward
                curr = (curr + jump + n)%n; //going to next index;

                //in a loop or already processed
                if(map.containsKey(curr)){

                    if(map.get(curr)==start){
                        return true;
                    }
                    break;
                }

            }
        }

        return false;
    }

    public boolean isValidCycle(int start, int curr, int[] arr){

        if((arr[start]>0 && arr[curr]<0 )|| (arr[start]<0 && arr[curr]>0) ||                                                  (arr[curr]%arr.length==0) ){
            return false;
        }

        return true;
    }
}
