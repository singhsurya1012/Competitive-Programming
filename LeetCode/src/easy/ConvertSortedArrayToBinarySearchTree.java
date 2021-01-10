package easy;

public class ConvertSortedArrayToBinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return convertToBalancedBST(nums, 0, nums.length - 1);

    }


    private TreeNode convertToBalancedBST(int[] nums, int start, int end) {


        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = convertToBalancedBST(nums, start, mid - 1);
        node.right = convertToBalancedBST(nums, mid + 1, end);

        return node;

    }
}
