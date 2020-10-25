package medium;

import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] T) {

        int [] arr = new int[T.length];

        //We will maintain the index of strictly increasing index
        Stack<Integer> stack = new Stack<>();

        for(int i = T.length-1; i>=0; i--) {

            //Checking if the current temp is greater than the top of stack
            //If not remove the top
            while(!stack.isEmpty() && T[i]>=T[stack.peek()]) {
                stack.pop();
            }

            //If stack is empty means there is no temp greater than current
            if(stack.isEmpty()) {
                arr[i] = 0;
            }else {
                //Else we know the top of stack temp is greater than current temp
                //So we just need to know the difference in index
                arr[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return arr;
    }
}
