package easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for(int i: nums1){
            set.add(i);
        };


        for(int i: nums2){
            if(set.contains(i)){
                intersection.add(i);
                set.remove(i);
            }
        }

        int[] arr = new int[intersection.size()];
        int index=0;
        for(int i: intersection){
            arr[index++] = i;
        }

        return arr;
    }
}
