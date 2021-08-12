package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String s) {

        int n = s.length();
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        int max = 0;
        int letter = 0;

        for (int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                letter = i;
            }
        }

        int otherChar = n - max;

        if (max > otherChar + 1) {
            return "";
        }

        char[] result = new char[n];
        int index = 0;

        while (arr[letter] > 0) {
            result[index] = (char) (letter + 'a');
            arr[letter]--;
            index += 2;
        }

        for (int i = 0; i < 26; i++) {

            while (arr[i] > 0) {

                if (index >= n) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index += 2;
                arr[i]--;
            }
        }

        return String.valueOf(result);
    }


    public String reorganizeStringUsingPriorityQueue(String s) {

        int n = s.length();
        if (n == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        map.forEach((k, v) -> queue.offer(new int[]{k, v}));

        int max = queue.peek()[1];
        int otherChar = n - max;

        if (max > otherChar + 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {

            int[] first = queue.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                first[1]--;
                if (first[1] != 0)
                    queue.offer(first);
            } else {
                int[] second = queue.poll();
                sb.append((char) second[0]);
                second[1]--;
                if(second[1]!=0)
                    queue.offer(second);
                queue.offer(first);
            }
        }

        return sb.toString();
    }
}
