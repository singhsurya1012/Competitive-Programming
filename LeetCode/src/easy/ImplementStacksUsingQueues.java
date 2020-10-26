package easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStacksUsingQueues {

    class MyStack {

        /**
         * Initialize your data structure here.
         */
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {

            q2.offer(x);

            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }


            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

        }

        public void pushSingleQueue(int x) {

            q1.offer(x);
            int size = q1.size();
            while (size > 1) {
                q1.offer(q1.poll());
                size--;
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q1.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q1.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
