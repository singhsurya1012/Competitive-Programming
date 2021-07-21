package medium;

public class DuplicatesFromSortedListII {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = head.next;

        while (next != null) {

            if (curr.val == next.val) {

                while (next != null && curr.val == next.val) {
                    next = next.next;
                }

                prev.next = next;
                curr = next;

                if (next != null)
                    next = next.next;

            } else {
                prev = curr;
                curr = next;
                next = next.next;
            }
        }

        return dummy.next;
    }
}
