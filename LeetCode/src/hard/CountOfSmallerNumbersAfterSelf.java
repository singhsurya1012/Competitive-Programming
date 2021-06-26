package hard;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {

    class Num {
        int index;
        int val;

        public Num(int i, int v){
            this.index = i;
            this.val = v;
        }
    }

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        Num[] arr = new Num[n];

        Map<Integer, Integer> map = new LinkedHashMap<>(n);

        for(int i=0; i<n;i++){
            arr[i] = new Num(i,nums[i]);
            map.put(i,0);
        }

        count(arr,map,0,n-1);
        return new ArrayList<>(map.values());
    }


    public void count(Num[] arr, Map<Integer, Integer> map, int l, int r ){

        if(l<r){

            int m = (l+r)/2;

            count(arr,map,l,m);
            count(arr,map,m+1,r);

            merge(arr,map,l,m,r);
        }
    }


    public void merge(Num[] arr, Map<Integer, Integer> map, int start, int mid, int end){

        int k = 0;
        Num[] temp = new Num[end-start+1];
        int j = mid+1;

        for(int i=start;i<=mid; i++){

            while(j<=end && arr[i].val>arr[j].val){
                temp[k++] = arr[j++];
            }
            temp[k++]=arr[i];
            map.put(arr[i].index, map.get(arr[i].index) + j-mid-1);
        }



        while(j<=end){
            temp[k++] = arr[j++];
        }
        for(int i=0; i<temp.length;i++){
            arr[start+i] = temp[i];
        }

    }
}
