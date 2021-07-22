package medium;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class CodecPreOrder {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            StringBuilder sb = new StringBuilder();
            if (root == null)
                return sb.toString();

            encode(root, sb);

            return sb.substring(0, sb.length() - 1);
        }

        public void encode(TreeNode node, StringBuilder sb) {

            if (node == null) {
                return;
            }

            sb.append(node.val);
            sb.append(" ");

            encode(node.left, sb);
            encode(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if (data.length() == 0)
                return null;


            String[] nodes = data.split(" ");
            Queue<Integer> q = new LinkedList<>();
            for (String n : nodes) {
                q.offer(Integer.parseInt(n));
            }

            return decode(nodes, q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode decode(String[] nodes, Queue<Integer> q, int lower, int upper) {

            if (q.isEmpty())
                return null;

            int val = q.peek();
            if (val < lower || val > upper)
                return null;

            TreeNode node = new TreeNode(val);
            q.poll();

            node.left = decode(nodes, q, lower, val);
            node.right = decode(nodes, q, val, upper);

            return node;
        }

    }

    class CodecLevelOrder {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            StringBuilder sb = new StringBuilder();
            if (root == null)
                return sb.toString();

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {

                TreeNode n = q.poll();
                sb.append(n.val + " ");

                if (n.left != null)
                    q.offer(n.left);

                if (n.right != null)
                    q.offer(n.right);
            }

            return sb.substring(0, sb.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(" ");

            TreeNode root = null;
            if (data.length() == 0)
                return root;

            root = new TreeNode(Integer.parseInt(nodes[0]));
            for (int i = 1; i < nodes.length; i++) {
                insert(Integer.parseInt(nodes[i]), root);
            }

            return root;
        }

        public TreeNode insert(int val, TreeNode node) {

            if (node == null) {
                node = new TreeNode(val);
                return node;
            }

            if (val < node.val)
                node.left = insert(val, node.left);
            else
                node.right = insert(val, node.right);

            return node;
        }

    }
}
