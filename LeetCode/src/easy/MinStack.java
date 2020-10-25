package easy;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    //Add the last min value whenever we encounter a new min vale
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    //If we remove the value which is current min
    //Means we have the next min as the next element which was added
    public void pop() {
        int val = stack.pop();

        if (val == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
