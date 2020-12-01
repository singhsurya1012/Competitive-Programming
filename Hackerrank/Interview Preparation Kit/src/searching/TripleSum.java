package searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripleSum {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {

        //Since we need distinct triplets we need to remove duplicates
        a = removeDuplicatesAndSort(a);
        b = removeDuplicatesAndSort(b);
        c = removeDuplicatesAndSort(c);

        long triplets = 0;
        for (int q : b) {

            //We find the index of the first value bigger then q
            //All values before this index will be a valid (p<=q)
            //For index i there will be i valid values
            //Since array is sorted we can use binary search to find the first largest value

            long p = search(a,q);

            //Similarly we find the first largest value in other array
            long r = search(c,q);

            //Number of combinations is selecting 1 from the first array and 1 from the second array
            //So if there are p and q valid values in array a and c
            //triplets = pC1 * qC1 = p*q
            triplets += p*r;
        }

        return triplets;
    }

    //Simple binary search function to find the first largest value
    private static long search(int[] arr, int t){

        int l = 0;
        //Note range will be till arr.length
        //since there is a chance that all the values are less than target
        int r = arr.length;

        while(l<r){

            int m = l+ (r-l)/2;

            //If mid value is equal or less we can move the lower bound
            //We dont need to include mid since it cant be valid value
            //Else we move the upper bound and we need to include m since it can be the first biggest value
            if(arr[m]<=t){
                l = m+1;
            }else{
                r = m;
            }
        }

        return l;
    }

    //Simple function to sort and remove duplicates without using any fancy Java 8 stream api
    private static int[] removeDuplicatesAndSort(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        int[] arr = new int[set.size()];

        int index = 0;
        for(Integer i: set){
            arr[index++] = i;
        }
        Arrays.sort(arr);
        return arr;
    }
}
