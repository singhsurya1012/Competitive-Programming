package stackandqueue;

import java.util.Stack;

public class ATaleOfTwoStack {

    static class MyQueue<T> {

        Stack<T> s1;
        Stack<T> s2;
        T top;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
            top = null;
        }

        public void enqueue(T val) {
            if (s1.isEmpty()) {
                top = val;
            }
            s1.push(val);
        }

        public void dequeue() {

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            s2.pop();
        }


        public T peek() {

            if (s2.isEmpty()) {
                return top;
            } else {
                return s2.peek();
            }
        }
    }
}
