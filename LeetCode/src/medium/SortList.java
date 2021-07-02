package medium;

public class SortList {

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode sortList(ListNode head) {

        return sort(head);
    }


    public ListNode sort(ListNode node){

        if(node==null || node.next==null)
            return node;

        ListNode dummy = new ListNode();
        dummy.next = node;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next=null;

        ListNode left = sort(node);
        ListNode right = sort(next);

        return merge(left,right);
    }


    public ListNode merge(ListNode left, ListNode right){

        if(left==null)
            return right;

        if(right==null)
            return left;

        if(left.val<=right.val){
            left.next = merge(left.next,right);
            return left;
        }else{
            right.next = merge(left,right.next);
            return right;
        }
    }
}
