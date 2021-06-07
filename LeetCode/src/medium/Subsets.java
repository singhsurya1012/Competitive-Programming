package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();

        //return cascade(nums);
        //return generateAllByLength(nums);
        return bitMagic(nums);
        //permute(nums,0, list);
        //return ans;



    }

    public List<List<Integer>> generateAllByLength(int[] nums){

        for(int len=0; len<=nums.length; len++){
            backtrack(0,len, new ArrayList<Integer>(), nums);
        }
        return ans;
    }

    public void backtrack(int pos, int len, List<Integer> list, int[] nums){
        if(list.size()==len){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=pos; i<nums.length; i++){
            list.add(nums[i]);
            backtrack(i+1, len, list, nums);
            list.remove(list.size()-1);
        }
    }

    public void permute(int[]nums , int pos, List<Integer> list){

        if(pos>=nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        //Exclude current num
        permute(nums, pos+1, list);

        List<Integer> include = new ArrayList<>(list);
        include.add(nums[pos]);
        permute(nums,pos+1, include);

    }


    public List<List<Integer>> cascade(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for(int n:nums){
            int size = ans.size();
            for(int i=0;i<size;i++){
                List<Integer> nextSet = new ArrayList<>(ans.get(i));
                nextSet.add(n);
                ans.add(nextSet);
            }
        }

        return ans;

    }


    public List<List<Integer>> bitMagic(int[] nums){
        int n = 1<<nums.length;

        for(int i=0; i<n;i++){
            int t = i;

            List<Integer> subset = new ArrayList<Integer>();
            for(int j=0 ; j<nums.length; j++){

                if(t==0)
                    break;

                if(t%2==1){
                    subset.add(nums[j]);
                }

                t = t>>1;
            }

            ans.add(subset);
        }

        return ans;
    }
}
