package medium;

public class RangeSumQueryMutable {

    class NumArray {

        int[] nums;
        int[] block;
        int b;

        public NumArray(int[] nums) {

            this.nums = nums;
            int n = nums.length;
            this.b = (int) Math.sqrt(nums.length);
            int sz = (n+b-1)/b;
            this.block = new int[sz];

            for(int i=0; i<n;i++){
                this.block[i/b]+=this.nums[i];
            }
        }

        public void update(int index, int val) {
            int old = this.nums[index];
            this.nums[index] = val;
            block[index/b] = block[index/b] - old + val;
        }

        public int sumRange(int left, int right) {

            int lb = left/b;
            int rb = right/b;

            int sum = 0;

            if(lb==rb){
                for(int i=left;i<=right; i++){
                    sum+=nums[i];
                }
            }else{

                //firstBlock
                for(int i=left; i<=(lb+1)*b-1; i++)
                    sum+=nums[i];

                //middleBlocks
                for(int i=lb+1; i<=rb-1;i++)
                    sum+=block[i];

                //endBlock
                for(int i=rb*b; i<=right;i++)
                    sum+=nums[i];
            }

            return sum;
        }
    }
}
