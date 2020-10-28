package easy;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {

        int l = needle.length();

        if (l == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - l; i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {

                if (checkMatch(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean checkMatch(String haystack, String needle, int index) {

        for (int i = 1; i < needle.length(); i++) {

            if (needle.charAt(i) != haystack.charAt(index + i)) {
                return false;
            }
        }

        return true;
    }
}
