package medium;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

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

    public ListNode removeZeroSumSublists(ListNode head) {

        Map<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int sum = 0;
        ListNode curr = dummy;

        while (curr != null) {
            sum += curr.val;
            map.put(sum, curr);
            curr = curr.next;
        }

        curr = dummy;
        sum = 0;

        while (curr != null) {

            sum += curr.val;
            if (map.containsKey(sum)) {
                curr.next = map.get(sum).next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    public ListNode removeZeroSumSublistsSlow(ListNode head) {

        Map<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int sum = 0;
        ListNode curr = dummy;

        while (curr != null) {

            sum += curr.val;

            if (map.containsKey(sum)) {
                curr = map.get(sum).next;
                int p = sum + curr.val;
                while (sum != p) {
                    map.remove(p);
                    curr = curr.next;
                    p += curr.val;
                }
                map.get(sum).next = curr.next;
            } else {
                map.put(sum, curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
