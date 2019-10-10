package codes;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.SortedSet;
import java.util.TreeSet;

public class TaskD {

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String str = in.nextString();
        StringBuilder sb = new StringBuilder(str);
        SortedSet<Integer>[] charSetArray = new SortedSet[26];

        for (int i = 0; i < sb.length(); i++) {

            if (null == charSetArray[sb.charAt(i) - 'a']) {
                charSetArray[sb.charAt(i) - 'a'] = new TreeSet<>();
            }
            charSetArray[sb.charAt(i) - 'a'].add(i);
        }

        int numberOfQueries = in.nextInt();

        for (int i = 1; i <= numberOfQueries; i++) {

            int queryType = in.nextInt();

            if (2 == queryType) {

                int l = in.nextInt() - 1;
                int r = in.nextInt() - 1;

                int count = 0;

                for (SortedSet<Integer> set : charSetArray) {

                    if (null != set && !set.isEmpty() && null != set.tailSet(l) && !set.tailSet(l).isEmpty()) {

                        int first = set.tailSet(l).first();

                        if (first >= l && first <= r) {
                            count++;
                        }
                    }

                }

                out.println(count);

            } else {
                int pos = in.nextInt() - 1;
                char toBeAdded = in.next().charAt(0);

                charSetArray[sb.charAt(pos) - 'a'].remove(pos);
                sb.setCharAt(pos, toBeAdded);

                if (null == charSetArray[sb.charAt(pos) - 'a']) {
                    charSetArray[sb.charAt(pos) - 'a'] = new TreeSet<>();
                }
                charSetArray[sb.charAt(pos) - 'a'].add(pos);


            }

        }
    }
}
