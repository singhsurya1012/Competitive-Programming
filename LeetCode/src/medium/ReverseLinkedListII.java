package medium;

public class ReverseLinkedListII {

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

    //ListNode tail;
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        if (left == right)
            return head;


        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode curr = dummy;
        for (int i = 0; i < left - 1; i++) {
            curr = curr.next;
        }

        curr.next = reverse(curr.next, right - left);
        return dummy.next;
    }

    public ListNode reverse(ListNode node, int n) {

        if (node.next == null || n == 0) {
            //tail = node.next;
            return node;
        }

        ListNode head = reverse(node.next, n - 1);

        ListNode tail = node.next.next;
        node.next.next = node;
        node.next = tail;

        return head;

    }
}
