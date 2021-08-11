package medium;

public class SingleNumberII {

    public int singleNumber(int[] nums) {

        int res = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = 1 << i;

            for (int n : nums) {
                if( (n & mask) != 0)
                    sum++;
            }
            if (sum % 3 == 1)
                res |= mask;
        }
        return res;
    }

}
