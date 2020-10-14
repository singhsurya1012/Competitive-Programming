package easy;

public class MergeTwoSortedList {

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = null;

        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode temp = head;

        while (true) {

            //If we reach the end of a list then we attach the other list to the tail
            if (l1 == null) {
                temp.next = l2;
                break;
            }

            if (l2 == null) {
                temp.next = l1;
                break;
            }

            //Whichever value is lower we attach that to the temp
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            //move the temp so that new node is attached afterwards
            temp = temp.next;
        }

        return head;
    }


    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {

        //Base case when there is only one element left
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //attach the next node of the smaller node with the remaining sorted list
        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }


    public ListNode mergeTwoListsInPlace(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        //Making the first list smaller
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        //Maintain 2 pointer to check if the other list node is between these two pointers;
        ListNode curr1 = l1;
        ListNode next1 = l1.next;

        ListNode curr2 = l2;

        //If we don't have any node in the first list then attach the second list directly;
        if (next1 == null) {
            curr1.next = curr2;
            return l1;
        }

        //Check till we have any element left in the second list
        while (curr2 != null) {

            //Compare it with the first list nodes if it is in between the two nodes
            if (curr2.val >= curr1.val && curr2.val < next1.val) {

                //Keep the next node of the second list
                ListNode next2 = curr2.next;

                //Insert curr2 in between curr1 and next1
                curr1.next = curr2;
                curr2.next = next1;

                //Move th curr1 to the next node
                curr1 = curr2;
                //Move to the next node in the second list
                curr2 = next2;

            } else {

                //Check if there is no element left in the first list
                if (next1.next == null) {
                    next1.next = curr2;
                    return l1;
                } else {
                    curr1 = next1;
                    next1 = next1.next;
                }

            }
        }

        return l1;
    }
}
