package easy;

public class ReverseLinkedList {

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
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        //Take 3 nodes prev, curr and next approach
        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public ListNode reverseListRecursive(ListNode head) {

        if(head==null || head.next==null) {
            return head;
        }

        //This will return the last element, so we return it finally as head
        ListNode node = reverseList(head.next);

        //We get the next node of current node and set its next to current, there by reversing the link
        head.next.next = head;
        //Deleting the current forward link
        head.next = null;

        return node;


    }
}
