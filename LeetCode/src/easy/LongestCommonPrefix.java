package easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        //Take the first string
        String first = strs[0];
        int l = first.length();
        //Longest possible prefix is the first string length
        int prefix = l;

        for (int i = 1; i < strs.length; i++) {

            String curr = strs[i];
            int p = 0;

            //Compare the first string with each string
            //We don't need to compare anything beyond prefix length since
            //Compare only till the minimum(prefix,first str length, curr str length)
            for (int j = 0; j < Integer.min(prefix, Integer.min(l, curr.length())); j++) {

                char c = curr.charAt(j);
                char f = first.charAt(j);

                if (c == f) {
                    p++;
                } else
                    break;
            }
            prefix = Integer.min(prefix, p);

            //If at anytime prefix reaches 0 means there is no common string
            if (prefix == 0) {
                return "";
            }

        }
        return first.substring(0, prefix);
    }
}
