package searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwapNodes {

    static class Node {

        int data;
        Node left;
        Node right;
        int level;

        public Node(int data, int level) {
            super();
            this.data = data;
            this.level = level;
        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(1, 1);
        Node currNode = null;
        queue.offer(root);

        int[][] sol = new int[queries.length][indexes.length];

        for (int i = 0; i < indexes.length; i++) {

            currNode = queue.poll();

            int a = indexes[i][0];
            int b = indexes[i][1];

            if (a != -1) {
                currNode.left = new Node(a, currNode.level + 1);
                queue.offer(currNode.left);
            }

            if (b != -1) {
                currNode.right = new Node(b, currNode.level + 1);
                queue.offer(currNode.right);
            }


        }


        for (int i = 0; i < queries.length; i++) {

            int swapLevel = queries[i];

            swap(root, swapLevel, 1);
            List<Integer> array = new ArrayList<>();
            inOrderTraverse(root, array);


            sol[i] = array.stream().mapToInt(a -> a).toArray();

        }


        return sol;


    }


    private static void swap(Node node, int swapLevel, int multiple) {

        // TODO Auto-generated method stub
        if (node.level == swapLevel * multiple) {

            Node left = node.left;
            Node right = node.right;

            node.right = left;
            node.left = right;

            swap(node, swapLevel, multiple + 1);


        } else {

            if (node.left != null) {
                swap(node.left, swapLevel, multiple);
            }

            if (node.right != null) {
                swap(node.right, swapLevel, multiple);
            }
        }
    }


    private static void inOrderTraverse(Node n, List<Integer> arr) {
        if (n.left != null) {
            inOrderTraverse(n.left, arr);
        }

        arr.add(n.data);

        if (n.right != null) {
            inOrderTraverse(n.right, arr);
        }
    }

}
