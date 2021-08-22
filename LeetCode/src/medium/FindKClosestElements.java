package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {

    public List<Integer> findClosestElementsClean(int[] arr, int k, int x) {

        int n = arr.length;
        int l=0;
        int r = n-k;

        while(l<r){
            int m = (l+r)/2;

            if(x-arr[m]>arr[m+k]-x)
                l = m+1;
            else
                r = m;
        }

        return Arrays.stream(arr,l,l+k).boxed().collect(Collectors.toList());
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;

        //If target is smaller than first element then first k elements will be closest
        if (x <= arr[0]) {
            return sublist(arr, 0, k);
        }

        //If target is bigger than last element then last k element will be closest
        if (arr[n - 1] <= x) {
            return sublist(arr, n - k, n);
        }


        //Find the position of target if present
        int l = 0;
        int r = arr.length - 1;
        while (l + 1 < r) {

            int m = l + (r - l) / 2;

            if (arr[m] > x) {
                r = m;
            } else {
                l = m;
            }
        }


        //Find the k closest elements from the target
        while (k > 0) {
            if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                l--;
            } else {
                r++;
            }

            k--;
        }


        return sublist(arr, l + 1, r);
    }


    public List<Integer> sublist(int[] arr, int start, int end) {
        List<Integer> l = new ArrayList<>();
        for (int i = start; i < end; i++) {
            l.add(arr[i]);
        }

        return l;
    }


}
