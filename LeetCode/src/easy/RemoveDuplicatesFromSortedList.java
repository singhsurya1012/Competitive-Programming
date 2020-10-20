package easy;

public class RemoveDuplicatesFromSortedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Time Complexity : O(1)
    //Space Complexity : O(1)
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //We Keep track of the previous and the current node
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {

            //Check if the current value is greater than the previous value
            if (curr.val > prev.val) {
                ///Link the prev node with the current node
                prev.next = curr;
                //Update the prev node to the new node
                prev = curr;
            }

            //Else we move till we find a node with value greater than prev node
            curr = curr.next;
        }

        if (curr.val != prev.val) {
            prev.next = curr;
        } else {
            prev.next = null;
        }

        return head;

    }


    //In this case we just check the current with the next
    //If they are same we delete the next node
    //It is less efficient since if we have same values continuously we will be deleting it one by one
    //Instead of directly skipping to the new value
    public ListNode deleteDuplicatesLessEfficient(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
