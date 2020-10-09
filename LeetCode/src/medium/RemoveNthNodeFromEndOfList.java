package medium;

public class RemoveNthNodeFromEndOfList {

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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pt1 = head;
        ListNode pt2 = head;

        //To remove a node we need access to its previous node
        //Using second pointer move the second pointer ahead by n
        while (n-- > 0) {
            pt2 = pt2.next;
        }

        //When second pointer is at last element of second means the first pointer is at the the position before the element to be removed
        //Special case when pointer is already null means we are at the node which we want to removed, in this case head
        if (pt2 == null) {
            return head.next;
        }

        //move till we reach the end and check if by seeing the next node
        while (pt2.next != null) {

            pt1 = pt1.next;
            pt2 = pt2.next;
        }

        //Remove the next node
        pt1.next = pt1.next.next;
        return head;


    }
}
