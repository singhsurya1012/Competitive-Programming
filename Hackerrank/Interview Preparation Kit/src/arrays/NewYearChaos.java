package arrays;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int swaps = 0;

        //Considering index 0 as starting position
        for (int i = q.length - 1; i >= 0; i--) {

            int currentPosition = i;
            int originalPosition = q[i] - 1;

            if (originalPosition - currentPosition > 2) {
                System.out.println("Too chaotic");
                return;
            }

            //Now check from 1 position in front of my original postion to person in front of my current position
            //We check 1 in front of original position because the first person who bribed me can also bribe the next person and go at max 1 ahead of me
            //Also this is not possible in case my postion is first postion hence checking max(0, originalPosition-1)
            for (int j = Math.max(originalPosition - 1, 0); j <= currentPosition - 1; j++) {

                //Any person who has value greater than me has bribed me at somepoint
                if (q[j] > q[i]) {
                    swaps++;
                }
            }
        }
        System.out.println(swaps);
    }
}
