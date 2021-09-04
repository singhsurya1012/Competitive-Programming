package hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustifyClean(String[] words, int maxWidth) {

        int left = 0;
        int n = words.length;

        List<String> result = new ArrayList<>();
        while (left < n) {

            int right = findRight(left, words, maxWidth);
            result.add(justify(words, left, right, maxWidth));
            left = right + 1;
        }

        return result;

    }

    private String justify(String[] words, int left, int right, int maxWidth) {

        if (left == right) {
            return padString(words[left], maxWidth);
        }

        boolean isLastLine = right == words.length - 1;
        int spaceLeft = maxWidth - wordLength(left, right, words);
        int partitions = right - left;

        String blankSpace = isLastLine ? " " : blank(spaceLeft / partitions);
        int remainder = isLastLine ? 0 : spaceLeft % partitions;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++) {
            result.append(words[i])
                    .append(blankSpace)
                    .append(remainder-- > 0 ? " " : "");
        }
        return padString(result.toString().trim(), maxWidth);
    }

    private int wordLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++)
            wordsLength += words[i].length();
        return wordsLength;
    }

    private String padString(String word, int maxWidth) {
        return word + blank(maxWidth - word.length());
    }

    private String blank(int len) {
        StringBuilder sb = new StringBuilder();
        while (len-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int size = words[right].length();
        right++;

        while (right < words.length && (size + 1 + words[right].length() <= maxWidth)) {
            size += 1 + words[right].length();
            right++;
        }
        return right - 1;
    }


    public List<String> fullJustify(String[] words, int maxWidth) {

        int n = words.length;
        int start = 0;

        int size = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; ) {

            String w = words[i];
            if (size + w.length() > maxWidth) {

                result.add(justify(words, start, i - 1, size, maxWidth));
                start = i;
                size = 0;
            } else {

                size += w.length() + 1;
                i++;
            }

        }

        result.add(justify(words, start, n - 1, size, maxWidth));

        return result;

    }


    public String justify(String[] words, int start, int end, int size, int width) {


        if (end == words.length - 1 || end == start) {
            StringBuilder sb = new StringBuilder();
            while (start <= end) {
                sb.append(words[start++]).append(" ");
            }

            sb.deleteCharAt(sb.length() - 1);

            while (sb.length() < width) {
                sb.append(" ");
            }
            return sb.toString();
        }

        int totalWords = end - start + 1;
        int remainingSpace = width - (size - totalWords);


        StringBuilder[] arr = new StringBuilder[totalWords - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder(words[start++]);
        }

        int index = 0;
        while (remainingSpace > 0) {
            arr[index % arr.length].append(" ");
            remainingSpace--;
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder s : arr) {
            sb.append(s);
        }
        sb.append(words[end]);
        return sb.toString();
    }
}
