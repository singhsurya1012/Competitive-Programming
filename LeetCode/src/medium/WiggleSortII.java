package medium;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {

        int n = nums.length;

        int median = findKthLargestElement(nums, (n+1)/2);
        int[] temp = new int[n];

        int odd =1;
        int even = n%2==0?n-2:n-1;

        for(int i=0; i<n;i++){

            if(nums[i]>median){
                temp[odd] = nums[i];
                odd+=2;
                continue;
            }

            if(nums[i]<median){
                temp[even] = nums[i];
                even-=2;
                continue;
            }

        }

        while(odd<n){
            temp[odd] = median;
            odd+=2;
        }

        while(even>=0){
            temp[even] = median;
            even-=2;
        }

        for(int i=0;i<n;i++){
            nums[i] = temp[i];
        }


    }




    public int findKthLargestElement(int[] nums, int k) {

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
