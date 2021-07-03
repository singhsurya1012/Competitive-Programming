package easy;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {


    public boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0; i<pieces.length;i++){
            map.put(pieces[i][0],pieces[i]);
        }


        for(int i=0; i<arr.length;){

            if(map.containsKey(arr[i])){

                int[] list = map.get(arr[i]);
                for(int j=0; j<list.length; j++){

                    if(i>=arr.length)
                        return false;

                    if(arr[i]!=list[j])
                        return false;

                    i++;
                }

            }else{
                return false;
            }
        }

        return true;
    }


    public boolean canFormArrayOtherApproach(int[] arr, int[][] pieces) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            map.put(arr[i],i);
        }


        for(int [] p: pieces){

            int lastIndex = -1;
            for(int val: p){

                if(!map.containsKey(val))
                    return false;

                int index = map.get(val);
                if(lastIndex!=-1 && lastIndex+1!=index)
                    return false;
                lastIndex = index;
            }
        }

        return true;
    }
}
