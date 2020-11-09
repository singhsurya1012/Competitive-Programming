package hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {

        //Since we want to find triplets with i<j<k
        //We cant calculate the other value of j and k directly since we dont know their relative occurrance

        //Hence we use two maps
        //This will store the values on the left
        Map<Long, Long> left = new HashMap<>();
        //This will store the values on the right
        Map<Long, Long> right = new HashMap<>();

        //Initially populating the right value
        for (long l : arr) {
            right.put(l, right.getOrDefault(l, 0l) + 1);
        }

        long ans = 0l;
        //Every element will be considered as middle element
        //So GP will be a/r , a , a*r
        for (long j : arr) {

            long leftCount = 0l;
            long rightCount = 0l;

            long i = 0l;

            //Check if left element is possible
            if (j % r == 0) {
                i = j / r;
            }
            //Right element
            long k = j * r;

            //Check the occurrance of left element
            leftCount = left.getOrDefault(i, 0l);

            //Decrease the count of current element from right map
            right.put(j, right.get(j) - 1);
            //Count the occurrence of right element
            rightCount = right.getOrDefault(k, 0l);

            ans += (leftCount * rightCount);
            //Add the current element in the left map since me are moving to the next element
            left.put(j, left.getOrDefault(j, 0l) + 1);
        }

        return ans;
    }

}
