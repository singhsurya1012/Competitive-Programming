package easy;

public class NumberOfOneBits {

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n&(n-1);
            count++;
        }

        return count;
    }

    public int loopAndFind(int n){

        int bits = 0;
        int val = n;

        while(val!=0){
            bits+=val&1;
            val=val>>>1;
        }

        return bits;
    }
}
