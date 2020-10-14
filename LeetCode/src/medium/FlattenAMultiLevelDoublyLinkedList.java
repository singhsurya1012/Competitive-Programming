package medium;

public class FlattenAMultiLevelDoublyLinkedList {


    class Node {
        int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        flat(head);
        return head;

    }

    public Node flat(Node node) {

        if (node.child != null) {

            Node lastNode = flat(node.child);
            Node next = node.next;

            node.next = node.child;
            node.next.prev = node;

            node.child = null;

            lastNode.next = next;

            if (next != null) {
                next.prev = lastNode;
            }

            node = lastNode;
        }

        if (node.next == null) {
            return node;
        }

        return flat(node.next);
    }
}
