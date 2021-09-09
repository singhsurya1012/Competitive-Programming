package medium;

public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {

        int sum = 0;
        int n = s.length();

        char[] arr = s.toCharArray();

        for (int i = n - 1; i >= 0; i--) {

            sum += shifts[i];
            sum = sum % 26;

            int c = (int) (arr[i] - 'a' + sum) % 26;
            arr[i] = (char) (c + 'a');
        }

        return new String(arr);
    }
}
