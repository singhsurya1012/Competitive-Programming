package stackandqueue;

import java.util.Stack;

public class PoisonousPlants {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {

        int n = p.length;
        Stack<Integer> stack = new Stack<>();
        int days = 0;

        //Mark the day it will be killed
        int[] killedOnDay = new int[n];
        killedOnDay[0] = 0;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            //If the current val greater than the stack top
            //It will be killed on the first day
            if (p[stack.peek()] < p[i]) {
                killedOnDay[i] = 1;
                stack.push(i);
            } else {

                //Else we need to check on which day it will be killed
                int d = 0;
                //Iterate till we find the killer (value less than current) or we reach empty stack
                //>= is important since we equal pesiticide cant kill
                while (!stack.isEmpty() && (p[stack.peek()] >= p[i])) {
                    //Top is not the killer means it will either be killed by someone after this or will not be killed at all
                    int top = stack.pop();
                    //Check its current day it will be killed
                    //This will atleast be killed a day after this plant
                    //Max is taken since we can can encounter someone who will be killed earlier
                    //Consider example [3,10,15,12,13,11] for better understanding
                    d = Math.max(killedOnDay[top], d);
                }

                //If we reached the end means it cant be killed
                if (stack.isEmpty()) {
                    killedOnDay[i] = 0;
                    stack.push(i);
                } else {
                    //It will be killed after d+1 days, since in d days its previous plants will be killed
                    killedOnDay[i] = d + 1;
                    stack.push(i);
                }
            }
        }

        //Find the max d
        //Can be done inside the original loop as well
        for (int i = 0; i < n; i++) {
            days = Math.max(days, killedOnDay[i]);
        }
        return days;
    }
}
