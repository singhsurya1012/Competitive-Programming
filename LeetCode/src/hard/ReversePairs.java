package hard;

public class ReversePairs {

    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length-1);

    }

    public int mergeSort(int[] nums, int start, int end){

        if(end==start){
            return 0;
        }

        int mid = (start+end)/2;

        int swaps = 0;
        swaps += mergeSort(nums, start, mid);
        swaps+= mergeSort(nums, mid+1,end);

        swaps+=merge(nums, start, mid, end);
        return swaps;
    }


    public int merge(int[] nums, int start, int mid, int end){

        int swaps=0;

        int j= mid+1;


        //Calculating swaps
        //For every i finding number of elements which can make pair with i
        //We dont need to reset j since all the pervious j will make pairs with nums ahead of i
        //Both merge and swap can be done in single loop
        for(int i=start;i<=mid; i++){

            while(j<=end && nums[i]>(2*(long)nums[j]))
                j++;

            swaps+=(j-(mid+1));

        }

        int l = start;
        int r = mid+1;

        int[] temp = new int[end-start+1];
        int k = 0;

        while(l<=mid && r<=end){

            if(nums[l]<nums[r]){
                temp[k++] = nums[l];
                l++;
            }else{

                temp[k++] = nums[r];
                r++;
            }
        }

        while(l<=mid){
            temp[k++] = nums[l++];
        }

        while(r<=end){
            temp[k++] = nums[r++];
        }

        for(int i=0; i<temp.length;i++){
            nums[start+i] = temp[i];
        }

        return swaps;
    }

    public int reversePairsBruteForce(int[] nums) {
        int pairs = 0;
        int n = nums.length;
        for(int i=0; i< n; i++){
            double n1 = nums[i]/2.0;
            for(int j=i+1; j<n;j++){
                if(n1>nums[j])
                    pairs++;
            }
        }
        return pairs;
    }
}
