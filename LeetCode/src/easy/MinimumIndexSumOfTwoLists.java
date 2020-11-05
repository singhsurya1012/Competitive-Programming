package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    //Time Complexity = O(l1+l2)
    //Space Complexity = 0(l1)
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();
        int minIndexSum = 2000;
        List<String> list = new ArrayList<>();

        //Maintain map of restaurants in list1 with its index as key
        for(int i=0; i<list1.length; i++){
            map.put(list1[i], i);
        }

        //For each restaurant in list 2 check if its present in map
        for(int i=0; i<list2.length; i++){

            //If present
            if(map.containsKey(list2[i])){
                //Check if sum is less than the minSum
                int indexSum = map.get(list2[i]) + i;

                //If less clear the list and add the current element
                //If sum is equal to min sum just add the restaurant
                if(indexSum<minIndexSum){
                    minIndexSum = indexSum;
                    list.clear();
                    list.add(list2[i]);
                }else if(indexSum==minIndexSum){
                    list.add(list2[i]);
                }
            }
        }

        return list.toArray(new String[list.size()]);

    }
}
