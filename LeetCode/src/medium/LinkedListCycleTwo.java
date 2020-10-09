package medium;

public class LinkedListCycleTwo {

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
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        //Using 2 pointer, if there is cycle the fast and slow pointer will coincide sometime or else the fast will reach the end
        if (head == null || head.next == null) {
            return null;
        }


        slow = slow.next;
        fast = fast.next.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        //Once we know there is cycle if we start moving 1 pointer from start and other pointer from matching node
        //They both will meet at the starting point of loop
        slow = head;

        while (slow != fast) {

            slow = slow.next;
            fast = fast.next;
        }


        return slow;
    }
}
