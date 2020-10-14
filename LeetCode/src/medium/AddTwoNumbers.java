package medium;

public class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //Create a new node and append the addition of each node to this node
        ListNode s = new ListNode(0);
        ListNode curr = s;

        int carry = 0;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null) {

            int sum = carry;

            if (p1 != null) {
                sum += p1.val;
            }
            if (p2 != null) {
                sum += p2.val;
            }

            //Calculate the sum and carry
            carry = sum / 10;
            sum = sum % 10;

            //Create new node and append it to the current node
            ListNode n = new ListNode(sum);
            curr.next = n;
            curr = curr.next;

            if (p1 != null) {
                p1 = p1.next;
            }

            if (p2 != null) {
                p2 = p2.next;
            }
        }

        //In the end of carry is still present we need to add a new node
        if (carry > 0) {
            ListNode n = new ListNode(1);
            curr.next = n;
        }

        return s.next;

    }
}
