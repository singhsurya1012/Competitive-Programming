package easy;

public class VerifyingAnAlienDictionary {

    private int[] arr = new int[26];

    public boolean isAlienSorted(String[] words, String order) {

        int size = words.length;
        if (size == 1)
            return true;

        fillOrder(order);

        for (int i = 1; i < size; i++) {

            String smaller = words[i - 1];
            String larger = words[i];

            if (!inOrder(smaller, larger)) {
                return false;
            }
        }

        return true;

    }


    private void fillOrder(String order) {

        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }
    }

    private boolean inOrder(String smaller, String larger) {

        char[] s = smaller.toCharArray();
        char[] l = larger.toCharArray();

        int n = s.length;
        int m = l.length;

        for (int i = 0; i < n; i++) {

            if (i >= m) {
                return false;
            }

            if (arr[s[i] - 'a'] < arr[l[i] - 'a']) {
                return true;
            } else if (arr[s[i] - 'a'] > arr[l[i] - 'a']) {
                return false;
            }
        }

        return true;
    }
}
