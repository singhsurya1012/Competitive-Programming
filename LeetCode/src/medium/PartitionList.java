package medium;

public class PartitionList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode b = new ListNode(0);
        ListNode a = new ListNode(0);

        ListNode before = b;
        ListNode after = a;

        ListNode curr = head;

        while (curr != null) {

            if (curr.val < x) {
                before.next = curr;
                before = before.next;
            } else {
                after.next = curr;
                after = after.next;
            }

            curr = curr.next;
        }

        after.next = null;
        after = a.next;
        a.next = null;

        before.next = after;
        before = b.next;
        b.next = null;

        return before;
    }


    public ListNode partitionBubbleSort(ListNode head, int x) {

        if(head==null){
            return head;
        }

        boolean swap = true;

        //We initialize swap to true and keep swapping till theres no more swaps
        while(swap){

            swap = false;

            //We need the curr and the prev pointers to swap a node.
            ListNode curr = head;
            ListNode prev = null;

            //Iterate till we reach the last node
            while(curr.next!=null){


                //if curr val is less than x or both current and next are greater then we can say that both curr and next are in correct order
                if(curr.val<x || (curr.val>=x && curr.next.val>=x)){

                    //So we simply move to the next node
                    prev = curr;
                    curr = curr.next;
                }else{

                    //Else if current is greater than x and next is less than x then we need to swap them
                    swap = true;


                    //we take the next node
                    ListNode next = curr.next;


                    //Assume x = 2
                    // prev --> 4(curr) --> 1(next) --> 5

                    //Point the currents next to next's next
                    //4(curr) --> 5
                    curr.next = next.next;

                    //1(next) --> 4(curr)
                    next.next = curr;

                    //Now we point the prev to this swapped node
                    //If prev is null means the new swapped node is head
                    if(prev == null){
                        head = next;
                    }else{
                        //Else me point the prev.next to the new swapped node which was next
                        //prev --> 1(next) --> 4(curr) --> 5
                        prev.next = next;
                    }

                    //Move the prev to next node
                    //Dont need to move the current node
                    prev = next;
                }

            }

        }

        return head;

    }
}
