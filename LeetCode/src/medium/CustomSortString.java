package medium;

public class CustomSortString {

    public String customSortString(String order, String str) {

        int[] arr = new int[26];
        for (char c : str.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {

            int occurences = arr[c - 'a'];
            while (occurences-- > 0) {
                sb.append(c);
            }
            arr[c - 'a'] = 0;
        }

        for (char c = 'a'; c <= 'z'; c++) {

            int occurences = arr[c - 'a'];
            while (occurences-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
