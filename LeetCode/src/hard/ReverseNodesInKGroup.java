package hard;

public class ReverseNodesInKGroup {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {


        ListNode curr = head;
        int pos = k;
        while (--pos > 0 && curr != null) {
            curr = curr.next;
        }

        if (curr == null)
            return head;

        ListNode next = curr.next;
        curr.next = null;

        ListNode newHead = reverse(head);
        head.next = reverseKGroup(next, k);

        return newHead;
    }


    public ListNode reverse(ListNode node) {

        if (node == null || node.next == null)
            return node;

        ListNode head = reverse(node.next);

        node.next.next = node;
        node.next = null;

        return head;
    }
}
