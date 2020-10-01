package easy;

public class HeightChecker {

    //Time Complexity : O(101)
    //Space Complexity : O(101)
    public int heightChecker(int[] heights) {
        int[] sortedHeights = new int[101];

        //Instead of Using sort function we can save heights at array index since 1<height[i]<100
        for (int i : heights) {
            sortedHeights[i]++;
        }

        int movement = 0;
        for (int i = 1, j = 0; i < 101 && j < heights.length; i++) {

            //If sortedHeight value is greater than zero, that value should be present in the original heights  sortedHeight value times
            while (sortedHeights[i] > 0) {

                if (i != heights[j]) {
                    movement++;
                }
                sortedHeights[i]--;
                j++;
            }
        }
        return movement;
    }
}
