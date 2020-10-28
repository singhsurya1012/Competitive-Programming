package easy;

public class AddBinary {

    public String addBinary(String a, String b) {


        int l = Math.max(a.length(), b.length());
        char[] arr = new char[l];

        char carry = '0';

        int alen = a.length() - 1;
        int blen = b.length() - 1;

        for (int i = l - 1; i >= 0; i--) {

            char aVal = '0';
            char bVal = '0';

            if (alen >= 0) {
                aVal = a.charAt(alen--);
            }

            if (blen >= 0) {
                bVal = b.charAt(blen--);
            }

            if (aVal == '1' && bVal == '1') {
                arr[i] = carry;
                carry = '1';
            } else if (aVal == '1' || bVal == '1') {

                if (carry == '1') {
                    arr[i] = '0';
                    carry = '1';
                } else {
                    arr[i] = '1';
                }

            } else {
                arr[i] = carry;
                carry = '0';
            }
        }

        if (carry == '1') {
            return "1" + new String(arr);
        } else {
            return new String(arr);
        }

    }
}
