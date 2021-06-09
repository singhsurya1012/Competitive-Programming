package medium;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] p = new int[n];
        //Each number in product consist of its left array product and right array product

        p[0]=1;
        for(int i=1; i<n; i++){
            p[i] = p[i-1]*nums[i-1];
        }


        int right = 1;
        for(int i=n-1; i>=0;i--){
            p[i] = p[i]*right;
            right = right*nums[i];
        }

        return p;
    }
}
