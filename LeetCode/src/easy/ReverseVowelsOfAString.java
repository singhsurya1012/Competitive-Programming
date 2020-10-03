package easy;

public class ReverseVowelsOfAString {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public String reverseVowels(String s) {

        int start = 0;
        int end = s.length() - 1;
        char[] charArray = s.toCharArray();

        while (start <= end) {

            boolean startVowel = isVowel(charArray[start]);
            boolean endVowel = isVowel(charArray[end]);

            if (startVowel && endVowel) {

                char c = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = c;

                start++;
                end--;
            } else if (startVowel) {
                end--;
            } else if (endVowel) {
                start++;
            } else {
                start++;
                end--;
            }
        }


        return new String(charArray);

    }


    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
