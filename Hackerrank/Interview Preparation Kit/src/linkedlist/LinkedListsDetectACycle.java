package linkedlist;

public class LinkedListsDetectACycle {


    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        if (head == null || head.next == null) {
            return false;
        }

        slow = slow.next;
        fast = fast.next.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }
}
