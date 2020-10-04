package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

    //Time Complexity : O(NLogN)
    //Space Complexity : O(N)
    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();
        //Creating queue with original index [0,1,2,....]
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        int[] arr = new int[deck.length];

        //Simulating the steps
        for (int card : deck) {

            //Added card at the index
            arr[queue.poll()] = card;

            //Remove the next index and push it to the end
            if (!queue.isEmpty())
                queue.add(queue.poll());
        }
        return arr;
    }


    //Time Complexity : O(NLogN)
    //Space Complexity : O(N)
    public int[] deckRevealedIncreasingWithoutQueue(int[] deck) {

        Arrays.sort(deck);

        int[] arr = new int[deck.length];
        int readIndex = 0;
        boolean reveal = true;

        while (readIndex < deck.length) {

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == 0) {

                    if (reveal) {
                        arr[i] = deck[readIndex];
                        readIndex++;
                        reveal = false;
                    } else {
                        reveal = true;
                    }
                }
            }
        }

        return arr;

    }
}
