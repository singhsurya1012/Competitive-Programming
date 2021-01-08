package medium;

public class DeleteNodeInABST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode deleteNode(TreeNode root, int key) {

        return deleteRecursive(root, key);
    }

    private TreeNode deleteRecursive(TreeNode node, int key) {

        if (node == null) {
            return node;
        }

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        } else if (key > node.val) {
            node.right = deleteNode(node.right, key);
            return node;
        } else {

            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {

                TreeNode parentSuccessor = node;
                TreeNode successor = node.right;

                while (successor.left != null) {
                    parentSuccessor = successor;
                    successor = successor.left;
                }

                node.val = successor.val;

                if (parentSuccessor == node) {
                    parentSuccessor.right = successor.right;
                } else {
                    parentSuccessor.left = successor.right;
                }


                return node;
            }

        }

    }


}
