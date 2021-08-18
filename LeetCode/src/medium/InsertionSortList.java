package medium;

public class InsertionSortList {

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

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(0);
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;

            ListNode pre = newHead;
            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }

            curr.next = pre.next;
            pre.next = curr;

            curr = next;
        }

        return newHead.next;

    }


    public ListNode insertionSortLists(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode newHead = head;
        ListNode curr = head.next;
        newHead.next = null;

        while (curr != null) {

            ListNode node = curr;
            curr = curr.next;
            node.next = null;
            newHead = insert(newHead, node);

        }

        return newHead;
    }

    public ListNode insert(ListNode head, ListNode node) {

        if (head.val > node.val) {
            node.next = head;
            return node;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null && curr.val <= node.val) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = node;
        node.next = curr;
        return head;
    }
}
