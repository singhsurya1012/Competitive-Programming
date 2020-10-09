package easy;

public class RemoveLinkedListElements {

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
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        ListNode curr = head;

        //To remove an element we need the previous node, so we check the next node value instead of current node
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }

        //Also check the head node since we always check the next node so the first node is missed
        if(head.val==val) {
            return head.next;
        }else {
            return head;
        }
    }
}
