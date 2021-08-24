package medium;

public class ComplexNumberMultiplication {

    public String complexNumberMultiplyClean(String num1, String num2){

        String x[] = num1.split("\\+|i");
        String y[] = num2.split("\\+|i");

        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);

        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";
    }

    public String complexNumberMultiply(String num1, String num2) {

        int[] a = getNum(num1);
        int[] b = getNum(num2);

        int real = a[0] * b[0] - a[1] * b[1];
        int imaginary = a[0] * b[1] + a[1] * b[0];

        StringBuilder sb = new StringBuilder();
        sb.append(real);
        sb.append("+");
        sb.append(imaginary);
        sb.append("i");

        return sb.toString();
    }

    public int[] getNum(String s) {
        int[] num = new int[2];

        int index = 0;
        while (s.charAt(index) != '+') {
            index++;
        }

        num[0] = Integer.parseInt(s.substring(0, index));
        num[1] = Integer.parseInt(s.substring(index + 1, s.length() - 1));

        return num;
    }
}
