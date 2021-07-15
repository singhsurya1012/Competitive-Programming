package medium;

import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        int triangles = 0;
        for(int i=0; i<=n-3; i++){
            int k = i+2;
            for(int j=i+1; j<=n-2 && nums[i]!=0; j++){

                int a = nums[i];
                int b = nums[j];

                int c = a+b;

                while(k<n && nums[k]<c){
                    k++;
                }

                triangles+=Math.max(0,k-j-1);
            }
        }

        return triangles;
    }


    public int triangleNumberBinarySearch(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        int triangles = 0;
        for(int i=0; i<=n-3; i++){
            int k = i+2;
            for(int j=i+1; j<=n-2 && nums[i]!=0; j++){

                int a = nums[i];
                int b = nums[j];

                int c = a+b;

                k = findIndex(nums, c,j+1,n);
                triangles+=k-j-1;
            }
        }

        return triangles;
    }

    public int findIndex(int[] nums, int c, int start, int end) {

        int l=start;
        int r=end;

        while(l<r){

            int m =(l+r)/2;

            if(nums[m]>=c){
                r = m;
            }else{
                l=m+1;
            }
        }

        return l;

    }

}
