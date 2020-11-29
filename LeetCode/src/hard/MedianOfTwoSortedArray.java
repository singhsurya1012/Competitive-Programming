package hard;

public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        // to ensure m<=n
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }


        int half = (m+n+1)/2;

        int l = 0;
        int r = m;

        //Break first array into two parts : leftA and rightA
        //Similarly break second array into two parts : leftB and rightB
        //Such that length of left part is equal to right part
        //Check if leftA is smaller than rightB and similarly leftB is smaller than rightA
        while(l<=r){

            //Find i and j
            //Check if the satisfy the condition
            int i = l+ (r-l)/2;

            int j = half-i;

            //If leftB is greater means we need to increase i
            if(i<r && nums1[i]<nums2[j-1]){
                l=i+1;
            }else if(i>0 && nums1[i-1]>nums2[j]){
                r=i-1;
            }else{

                //If total length is odd then median is max of leftA and leftB
                //If total length is even then median is average of max of (leftA,LeftB) and min of (rightA,rightB)
                int maxLeft = 0;

                if(i==0){
                    maxLeft = nums2[j-1];
                }else if(j==0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }

                //Odd Case
                if((m+n)%2==1){
                    return maxLeft;
                }

                int minRight = 0;
                if(i==m){
                    minRight = nums2[j];
                }else if(j==n){
                    minRight = nums1[i];
                }else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }

                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }
}
