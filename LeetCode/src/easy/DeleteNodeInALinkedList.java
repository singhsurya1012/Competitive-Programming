package easy;

public class DeleteNodeInALinkedList {

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
    public void deleteNode(ListNode node) {

        //To delete a node we always need its previous node
        //Since we don't have previous node we copy the next value in the current node
        //And instead of deleting the current node now we can delete the next node
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
