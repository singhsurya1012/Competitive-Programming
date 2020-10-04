package medium;

public class ContainerWithMoistWater {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int maxArea(int[] height) {

        int maxArea = 0;
        int len = height.length;

        int left = 0;
        int right = len - 1;

        //Maximum area that can be formed by line is its height * the farthest line with height at least equal to its own height
        //Using this condition we use two pointer and check the line which has the smallest height.
        //Calculate its area. This will be tha maximum area that can be formed using this line. So me move to the next index
        while (left < right) {

            //If left has less height. We calculate the max Area formed by this line and move to the next line
            if (height[left] <= height[right]) {
                maxArea = Math.max(maxArea, area(height[left], right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, area(height[right], right - left));

                right--;
            }
        }

        return maxArea;

    }


    public int area(int h, int b) {
        return h * b;
    }
}
