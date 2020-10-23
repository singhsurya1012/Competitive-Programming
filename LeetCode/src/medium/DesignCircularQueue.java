package medium;

public class DesignCircularQueue {

    class MyCircularQueue {

        private final int[] queue;
        private int head;
        private int tail;
        private int capacity;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            this.queue = new int[k];
            this.head = -1;
            this.tail = -1;
            this.capacity = k;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {

            if (isFull()) {
                return false;
            }

            if (isEmpty()) {
                head = 0;
            }

            tail = (tail + 1) % capacity;
            queue[tail] = value;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {

            if (isEmpty()) {
                return false;
            }

            if (head == tail) {
                head = -1;
                tail = -1;
                return true;
            }

            head = (head + 1) % capacity;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {

            if (isEmpty()) {
                return -1;
            }

            return queue[head];

        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {

            if (isEmpty()) {
                return -1;
            }
            return queue[tail];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return head == -1;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {

            return (tail + 1) % capacity == head;

        }
    }
}
