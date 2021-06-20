package easy;

public class RangeSumQueryImmutable {

    class NumArray {

        int[] nums;
        int[] prefix;

        public NumArray(int[] nums) {

            this.nums = nums;
            this.prefix = new int[nums.length];
            prefix[0]=nums[0];

            for(int i=1; i<prefix.length;i++){
                prefix[i] = nums[i]+prefix[i-1];
            }
        }

        public int sumRange(int left, int right) {

            return prefix[right] - ((left-1>=0) ? prefix[left-1] : 0);
        }
    }
}
