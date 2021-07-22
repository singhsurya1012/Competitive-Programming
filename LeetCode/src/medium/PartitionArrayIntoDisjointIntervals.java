package medium;

public class PartitionArrayIntoDisjointIntervals {

    public int partitionDisjointSpaceOptimised(int[] nums) {

        int n = nums.length;

        int globalMax = nums[0];
        int leftMax = nums[0];
        int pos = 0;

        for(int i=1;i<n;i++){

            globalMax = Math.max(globalMax,nums[i]);

            if(nums[i]<leftMax){
                leftMax = globalMax;
                pos = i;
            }
        }

        return pos+1;
    }

    public int partitionDisjoint(int[] nums) {

        int n = nums.length;

        int[] min = new int[n];
        min[n-1] = nums[n-1];
        for(int i = n-2; i>=0;i--){
            min[i] = Math.min(min[i+1],nums[i]);
        }

        int maxLeft = 0;

        for(int i=1;i<n;i++){

            maxLeft = Math.max(maxLeft,nums[i-1]);
            if(maxLeft<=min[i])
                return i;
        }

        return 0;
    }
}
