package medium;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        SumOfTwoIntegers s = new SumOfTwoIntegers();
        System.out.println(s.getSum(-985,-46));
    }

    public int getSum(int a, int b) {

        if(b==0){
            return a;
        }

        int sum = a^b;
        int carry = (a&b)<<1;
        return getSum(sum,carry);
    }

    public int getSumOnlyPositive(int a, int b) {

        String x = Integer.toBinaryString(a);
        String y = Integer.toBinaryString(b);

        if (x.length() < y.length()) {
            return add(y, x);
        } else {
            return add(x, y);
        }
    }

    private int add(String x, String y) {

        int n = x.length();
        int m = y.length();

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        int i, j;
        for (i = n - 1, j = m - 1; i >= 0 && j >= 0; i--, j--) {

            int a = x.charAt(i) - '0';
            int b = y.charAt(j) - '0';

            int val = (a ^ b) ^ carry;
            carry = (a & b) | (a & carry) | (b & carry);

            sb.append(val);
        }

        while(i>=0){

            int a = x.charAt(i--) -'0';
            int val = a^carry;
            carry = a&carry;

            sb.append(val);
        }

        if(carry!=0)
            sb.append(carry);
        sb.reverse();
        return Integer.parseInt(sb.toString(),2);
    }
}
