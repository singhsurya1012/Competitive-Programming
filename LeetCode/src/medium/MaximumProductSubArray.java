package medium;

public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];

        int currMax = nums[0];
        int currMin = nums[0];


        for(int i=1; i<nums.length;i++){

            if(nums[i]<0){
                int t = currMax;
                currMax = currMin;
                currMin = t;
            }

            currMax = Math.max(nums[i], currMax*nums[i]);
            currMin = Math.min(nums[i], currMin*nums[i]);

            maxProduct = Math.max(maxProduct,currMax);
        }

        return maxProduct;

    }
}
