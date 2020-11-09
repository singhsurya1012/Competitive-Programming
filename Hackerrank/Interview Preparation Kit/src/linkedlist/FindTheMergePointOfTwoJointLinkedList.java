package linkedlist;

public class FindTheMergePointOfTwoJointLinkedList {


    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode a = head1;
        SinglyLinkedListNode b = head2;


        while (a != b) {

            a = a.next;
            b = b.next;

            if (a == b) {
                return a.data;
            }

            if (a == null) {
                a = head2;
            }

            if (b == null) {
                b = head1;
            }

        }
        return a.data;
    }
}
