package medium;

public class JumpGameII {


    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] == 0) {
            return -1;
        }


        int maxReach = nums[0];
        int steps = nums[0];
        int jumps = 1;

        for (int i = 1; i < nums.length; i++) {

            if (i == nums.length - 1) {
                return jumps;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            steps--;

            if (steps == 0) {
                jumps++;

                if (i == maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }

        return -1;

    }
}
