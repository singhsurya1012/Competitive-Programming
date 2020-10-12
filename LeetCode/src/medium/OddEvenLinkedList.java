package medium;

public class OddEvenLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddTail = head;
        ListNode evenHead = head.next;

        ListNode even = head.next;

        while (even != null && even.next != null) {

            //Point the odd tail to the next odd node
            oddTail.next = even.next;
            //Move the odd tail to the newly added odd node
            oddTail = oddTail.next;

            //Point the current even node to the next even node
            even.next = oddTail.next;
            //Mode to the next even node
            even = even.next;

        }

        //Point the oddTail to the evenHead
        oddTail.next = evenHead;
        return head;

    }
}
