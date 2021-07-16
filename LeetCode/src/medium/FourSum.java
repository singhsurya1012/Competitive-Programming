package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSumGeneric(int[] nums, int target) {

        int n = nums.length;
        Arrays.sort(nums);

        return kSum(nums, 4, 0, target);
    }

    public List<List<Integer>> kSum(int[] nums, int k , int start, int target){
        List<List<Integer>> result = new LinkedList<>();
        int n = nums.length;

        if(start==nums.length)
            return result;

        if(k==2){
            return twoSum(nums, start, target);
        }



        for(int i=start;i<=n-k; i++){

            if(i!=start && nums[i]==nums[i-1])
                continue;

            for(List<Integer> l: kSum(nums,k-1,i+1,target-nums[i])){
                l.add(nums[i]);
                result.add(l);
            }
        }

        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target){

        List<List<Integer>> result = new LinkedList<>();

        int l=start;
        int r = nums.length-1;

        while(l<r) {

            int sum = nums[l] + nums[r];

            if(sum==target){

                List<Integer> ans= new LinkedList<>();
                ans.add(nums[l]);
                ans.add(nums[r]);
                result.add(ans);

                l++;
                r--;

                while(l<=r && nums[l]==nums[l-1]){
                    l++;
                }

                while(r>=l && nums[r]==nums[r+1]){
                    r--;
                }

            }else if(sum<target){
                l++;
            }else {
                r--;
            }
        }
        return result;
    }


    //Time Complexity = O(N^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {

        //Similar to 3 sum Just one extra Loop
        Arrays.sort(nums);
        List<List<Integer>> quad = new ArrayList<>();

        for (int i = 0; i < nums.length - 3 && nums[i] * 4 <= target; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> q = new ArrayList<>(4);
                        q.add(nums[i]);
                        q.add(nums[j]);
                        q.add(nums[left]);
                        q.add(nums[right]);
                        quad.add(q);

                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);

                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right + 1]);

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }


            }

        }

        return quad;

    }


}
