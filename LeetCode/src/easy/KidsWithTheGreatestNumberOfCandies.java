package easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {


        int max = 0;
        //Calculate the max Candies
        for(int i:candies) {
            max = Integer.max(i,max);
        }

        List<Boolean> l = new ArrayList<>(candies.length);

        for(int i:candies) {
            //If adding extra candies results in greater than max candies , store true
            l.add(i+extraCandies>=max);
        }

        return l;
    }
}
