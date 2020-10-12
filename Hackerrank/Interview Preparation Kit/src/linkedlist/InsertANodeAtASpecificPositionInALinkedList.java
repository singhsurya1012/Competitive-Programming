package linkedlist;

public class InsertANodeAtASpecificPositionInALinkedList {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        int currentIndex = 0;

        SinglyLinkedListNode currentNode = head;
        while (currentIndex < position - 1) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        node.next = currentNode.next;
        currentNode.next = node;

        return head;

    }
}
