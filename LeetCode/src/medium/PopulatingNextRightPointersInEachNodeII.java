package medium;

public class PopulatingNextRightPointersInEachNodeII {

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

        setNext(root);

        return root;

    }

    public void setNext(Node first) {

        if (first == null || (first.left == null && first.right == null)) {
            return;
        }


        //Two Children
        if (first.left != null && first.right != null) {
            first.left.next = first.right;

            Node n = first.next;
            while (n != null && (n.left == null && n.right == null)) {
                n = n.next;
            }

            if (n != null) {
                n = n.left != null ? n.left : n.right;
            }
            first.right.next = n;

        } else {

            Node n = first.next;
            while (n != null && (n.left == null && n.right == null)) {
                n = n.next;
            }

            if (n != null) {
                n = n.left != null ? n.left : n.right;
            }

            if (first.left != null) {
                first.left.next = n;
            } else {
                first.right.next = n;
            }

        }

        //Population Right Subtree first is important since we need it to reference next of left subtree
        setNext(first.right);
        setNext(first.left);
    }
}
