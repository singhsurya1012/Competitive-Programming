package easy;

public class PalindromeLinkedList {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPalindromeSimple(ListNode head) {


        if(head==null || head.next==null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);

        ListNode a = head;
        ListNode b = slow.next;

        while(b!=null){

            if(a.val!=b.val)
                return false;

            a = a.next;
            b = b.next;
        }

        slow.next = reverseList(slow.next);
        return true;

    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }


        ListNode slow = head;
        ListNode fast = head;

        //To Handle case for odd number of nodes
        ListNode midNode = null;
        ListNode prevSlow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            prevSlow = slow;
            slow = slow.next;
        }


        //Means there are odd number of nodes
        if (fast != null) {
            midNode = slow;
            slow = slow.next;
        }

        //End the first half node
        prevSlow.next = null;

        ListNode secondHalf = slow;
        //Reverse the second half
        secondHalf = reverseLinkedList(secondHalf);

        //Compare the two half
        boolean isPalindrome = compareList(head, secondHalf);

        //Revert to original
        secondHalf = reverseLinkedList(secondHalf);

        if (midNode != null) {
            prevSlow.next = midNode;
            midNode.next = secondHalf;
        }

        return isPalindrome;
    }


    public ListNode reverseLinkedList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode node = reverseLinkedList(head.next);

        head.next.next = head;
        head.next = null;

        return node;
    }


    public boolean compareList(ListNode head1, ListNode head2) {


        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                head1 = head1.next;
                head2 = head2.next;
            } else
                return false;
        }

        //Both are empty hence the list is same
        if (head1 == null && head2 == null)
            return true;

        //Else one list reached the end first
        return false;

    }

    public ListNode reverseList(ListNode node){

        ListNode prev = null;
        ListNode next = null;

        while(node!=null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
