package easy;

public class LinkedListCycle {

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
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        if (head == null || head.next ==null) {
            return false;
        }

        //Using 2 pointer, if there is cycle the fast and slow pointer will coincide sometime or else the fast will reach the end
        slow = slow.next;
        fast = fast.next.next;

        while (slow != fast) {

            //Check if fast has reached end. Then there is no cycle
            if (fast == null || fast.next == null) {
                return false;
            }

            //Move the pointers
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
