package medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(k);

        for(int i: nums){

            q.offer(i);
            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    public int findKthLargestQuickSort(int[] nums, int k) {

        int l=0;
        int r = nums.length-1;

        k = nums.length-k;

        while(l<r){

            int pivot = partition(nums,l,r);
            if(pivot<k){
                l=pivot+1;
            }else if(pivot>k){
                r = pivot-1;
            }else{
                return nums[k];
            }

        }

        return nums[k];
    }


    private int partition(int[] nums, int lo, int hi) {

        int pivot = nums[hi];

        int i = lo;

        for(int j=lo;j<hi;j++){

            if(nums[j]<=pivot){
                swap(nums,i,j);
                i++;
            }
        }

        swap(nums,i,hi);
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
