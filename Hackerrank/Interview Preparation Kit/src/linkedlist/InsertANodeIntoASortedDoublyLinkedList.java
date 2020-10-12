package linkedlist;

public class InsertANodeIntoASortedDoublyLinkedList {


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

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode node = new DoublyLinkedListNode(data);

        DoublyLinkedListNode curr = head;

        if (head == null) {
            head = node;
            return head;
        } else if (head.data >= node.data) {
            node.next = head;
            head.prev = node;
            return node;
        }

        while (data >= curr.data && curr.next != null) {
            curr = curr.next;
        }

        if (data > curr.data) {
            curr.next = node;
            node.prev = curr;
        } else {
            node.prev = curr.prev;
            node.next = curr;
            curr.prev.next = node;
            curr.prev = node;
        }

        return head;


    }

}
