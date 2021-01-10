package easy;

public class KthLargestElementInAStream {

    class KthLargest {

        int k;
        TreeNode root;

        public KthLargest(int k, int[] nums) {

            this.k = k;
            for (int i : nums) {
                this.root = insert(this.root, i);
            }

        }

        public int add(int val) {

            this.root = insert(this.root, val);
            return findKthNode(root, k).val;
        }

        public TreeNode findKthNode(TreeNode node, int k) {
            int rightSize = node.right == null ? 0 : node.right.size;

            if (k == rightSize + 1) {
                return node;
            }
            if (k > rightSize) {
                k = k - rightSize - 1;
                return findKthNode(node.left, k);
            } else {
                return findKthNode(node.right, k);
            }

        }

        public TreeNode insert(TreeNode node, int val) {

            if (node == null) {
                return new TreeNode(val);
            }

            if (val < node.val) {
                node.size++;
                node.left = insert(node.left, val);
            } else {
                node.size++;
                node.right = insert(node.right, val);
            }

            return node;
        }
    }


    class TreeNode {

        int val;
        int size;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.size = 1;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
