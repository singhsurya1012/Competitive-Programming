package easy;

public class ConvertBinaryNumberInALinkedListToInteger {

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
    public int getDecimalValue(ListNode head) {
        int decimal = head.val;

        //Doubling method to convert decimal to binary
        while (head.next != null) {
            decimal = decimal * 2 + head.next.val;
            head = head.next;
        }

        return decimal;
    }

}
