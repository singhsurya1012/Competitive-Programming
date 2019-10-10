package codes;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TaskB2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int numberOfMessages = in.nextInt();
        int numberOfConversationsAllowed = in.nextInt();

        Set<Integer> msgSet = new HashSet<>();
        List<Integer> msgList = new LinkedList<>();

        for (Integer i : in.nextIntArray(numberOfMessages)) {

            if (!msgSet.contains(i)) {

                if (msgList.size() >= numberOfConversationsAllowed) {
                    int lastElement = ((LinkedList<Integer>) msgList).removeLast();
                    msgSet.remove(lastElement);
                }
                ((LinkedList<Integer>) msgList).addFirst(i);
                msgSet.add(i);
            }
        }

        out.println(msgList.size());
        out.printIntegerList(msgList," ");


    }
}
