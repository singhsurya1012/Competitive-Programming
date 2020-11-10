package stackandqueue;

import java.util.Stack;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {

        long largestArea = 0l;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<h.length;){

            if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
                stack.push(i);
                i++;
            }else {

                long height = h[stack.pop()];
                int prev = stack.isEmpty()?-1:stack.peek();
                int breadth = i - prev - 1;

                largestArea = Math.max(largestArea, height*breadth);

            }
        }

        while(!stack.isEmpty()){

            long height = h[stack.pop()];
            int prev = stack.isEmpty()?-1:stack.peek();
            int breadth = h.length - prev - 1;
            largestArea = Math.max(largestArea, height*breadth);
        }

        return largestArea;
    }
}
