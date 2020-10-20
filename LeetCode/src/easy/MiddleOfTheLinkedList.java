package easy;

public class MiddleOfTheLinkedList {

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
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        //Using fast and slow pointer when the fast reached the end the slow will be at the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }
}
