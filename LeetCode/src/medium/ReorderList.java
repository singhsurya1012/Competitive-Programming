package medium;

import java.util.Stack;

public class ReorderList {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        slow.next = null;

        ListNode p2 = reverse(middle);

        overlap(head, p2);
    }

    private void overlap(ListNode p1, ListNode p2) {

        while (p1 != null && p2 != null) {

            ListNode n1 = p1.next;
            ListNode n2 = p2.next;
            p1.next = p2;
            p2.next = n1;

            p1 = n1;
            p2 = n2;
        }
    }

    private ListNode reverse(ListNode node) {

        if (node == null || node.next == null)
            return node;

        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderListUsingStack(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half = slow.next;
        slow.next = null;

        Stack<ListNode> stack = new Stack<>();

        while (half != null) {
            stack.add(half);
            half = half.next;
        }

        ListNode temp = head;

        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            ListNode next = temp.next;

            temp.next = top;
            top.next = next;
            temp = next;
        }
    }
}
