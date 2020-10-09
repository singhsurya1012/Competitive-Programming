package medium;

public class DesignLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    class MyLinkedList {

        int size;
        Node head;
        Node tail;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {

            //Check if index is out of range
            if (index < 0 || index >= size)
                return -1;

            int i = 0;
            Node curr = getNode(index);
            return curr.val;
        }


        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node newNode = new Node(val);

            //If head is null update head and tail to new node
            if (size == 0) {
                head = newNode;
                tail = head;
            } else {
                //just update the head
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {

            Node newNode = new Node(val);

            //If there is no element, update the head and tail to new node
            if (size == 0) {
                head = newNode;
                tail = head;
            } else {
                Node curr = tail;
                curr.next = newNode;
                tail = newNode;
            }
            size++;
        }


        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {

            //Check if index is in range
            if (index < 0 || index > size)
                return;

            //If index is zero add at head, or index is equal to size add at tail
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {

                //Get the previous element
                Node prev = getNode(index - 1);
                Node newNode = new Node(val);

                //Set the next node of new element to its prev node's next
                newNode.next = prev.next;
                //Update the prev node's next to new node
                prev.next = newNode;
                size++;
            }

        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {

            //Check if index is in range
            if (index < 0 || index >= size)
                return;

            //If there is only one element, set head and tail to null
            if (size == 1) {
                head = null;
                tail = null;
            } else if (index == 0) {
                //If index is 0, set head to the next element in line
                head = head.next;
            } else {

                //Get the prev node
                Node prev = getNode(index - 1);
                //Set prev node's next to its next's next
                prev.next = prev.next.next;

                //If index was the last element update tail to prev element
                if (index == size - 1) {
                    tail = prev;
                }
            }

            size--;
        }

        /**
         * Returns the ith node
         */
        private Node getNode(int index) {
            Node curr = head;
            int i = 0;
            while (i != index) {
                curr = curr.next;
                i++;
            }
            return curr;
        }

    }
}
