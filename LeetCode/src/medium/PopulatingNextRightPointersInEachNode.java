package medium;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        setNext(root, null);

        return root;

    }

    public void setNext(Node first, Node second) {

        if (first == null) {
            return;
        }

        first.next = second;

        if (first.left == null || first.right == null) {
            return;
        }

        setNext(first.left, first.right);

        if (second != null) {
            setNext(first.right, second.left);
        } else {
            setNext(first.right, null);
        }
    }


}
