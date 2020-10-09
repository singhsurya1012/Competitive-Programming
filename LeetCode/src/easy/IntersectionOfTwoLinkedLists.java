package easy;

public class IntersectionOfTwoLinkedLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Time Complexity : O(M+N)
    //Space Complexity : O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode ptA = headA;
        ListNode ptB = headB;


        if (ptA == null || ptB == null) {
            return null;
        }

        //Check till both the pointer reach the intersection or reach null at the same time after traversing both list
        //In the end both the pointer will travel travel the same length until the find intersection or reach end
        while (ptA != ptB) {

            ptA = ptA.next;
            ptB = ptB.next;

            if (ptA == ptB) {
                return ptA;
            }

            //If pointer A reached end move it to head of B list
            if (ptA == null) {
                ptA = headB;
            }

            //If pointer B reached end move it to head of A list
            if (ptB == null) {
                ptB = headA;
            }
        }
        return ptA;
    }
}
