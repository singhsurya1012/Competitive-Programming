package medium;

public class RotateList {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        //If there is no node or only 1 node
        if (head == null || head.next == null) {
            return head;
        }

        if (k == 0) {
            return head;
        }

        //Calculate the size of list while also maintaining the tail;
        int size = 1;
        ListNode pt1 = head;
        ListNode tail = null;
        while (pt1.next != null) {
            pt1 = pt1.next;
            size++;
        }
        //Tail is the last node
        tail = pt1;

        //Every size number of rotation results in the original list. hence taking mod
        k = k % size;

        if (k == 0) {
            return head;
        }

        pt1 = head;

        //Find the node before the new head after rotation
        for (int i = 1; i <= size - k - 1; i++) {
            pt1 = pt1.next;
        }


        //Set the new head
        ListNode newHead = pt1.next;
        //Point the current node to null as its the end of list
        pt1.next = null;
        //Point the tail to the start of the original list
        tail.next = head;

        return newHead;

    }
}
