package medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val);
        Node curr = newHead;

        Node pt = head;
        map.put(pt, newHead);


        while (pt != null) {

            Node next = pt.next;
            Node random = pt.random;

            if (null != next) {

                if (map.containsKey(next)) {
                    curr.next = map.get(next);
                } else {
                    Node n = new Node(next.val);
                    map.put(next, n);
                    curr.next = map.get(next);
                }
            }


            if (null != random) {

                if (map.containsKey(random)) {
                    curr.random = map.get(random);
                } else {
                    Node n = new Node(random.val);
                    map.put(random, n);
                    curr.random = map.get(random);
                }

            }

            curr = curr.next;
            pt = pt.next;

        }
        return newHead;
    }



    public Node copyRandomListOptimised(Node head) {

        if(head==null) {
            return null;
        }

        Node curr = head;

        //Interweave new list with old list
        //Old list a--> b --> c
        //New list a --> a' --> b --> b' --> c --> c'
        while(curr!=null) {

            Node n = new Node(curr.val);
            n.next = curr.next;
            curr.next = n;
            curr = n.next;
        }

        //Updating the random pointers
        curr =head;
        while(curr!=null && curr.next!=null) {

            if(curr.random!=null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //Removing the interweave
        Node newHead = null;
        Node tail = null;

        curr = head;
        while(curr!=null) {

            if(newHead==null) {
                newHead = curr.next;
                tail = curr.next;
            }else {
                tail.next = curr.next;
                tail = curr.next;
            }

            curr.next = curr.next.next;
            curr = curr.next;
        }
        return newHead;
    }

}
