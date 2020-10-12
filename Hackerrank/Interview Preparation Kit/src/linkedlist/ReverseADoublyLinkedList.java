package linkedlist;

public class ReverseADoublyLinkedList {


    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode curr = head;

        while (curr != null) {

            DoublyLinkedListNode next = curr.next;

            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        return prev;


    }

}
