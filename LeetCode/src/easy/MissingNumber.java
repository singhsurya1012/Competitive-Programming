package easy;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        int n = nums.length;
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        int expectedSum = n * (n + 1) / 2;

        return expectedSum - sum;
    }
}
