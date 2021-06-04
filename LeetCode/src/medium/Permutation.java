package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        permute(nums,0,list);

        return list;
    }

    public void permute(int[] nums, int pos, List<List<Integer>> list){
        if(pos==nums.length-1){
            list.add(getList(nums));
            return ;
        }

        for(int i=pos;i<nums.length;i++){
            swap(nums,i,pos);
            permute(nums,pos+1,list);
            swap(nums,i,pos);
        }
    }

    public List<Integer> getList(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i:arr){
            list.add(i);
        }
        return list;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}
