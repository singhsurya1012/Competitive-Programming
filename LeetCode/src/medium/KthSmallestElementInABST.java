package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInABST {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int kthSmallest(TreeNode node, int k){

        int count = countNodes(node.left);

        if(count+1==k)
            return node.val;

        //More than k elements in the left subtree
        if(count+1>k)
            return kthSmallest(node.left, k);
        else
            return kthSmallest(node.right, k-count-1);
    }

    public int countNodes(TreeNode n){

        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }


    public int kthSmallestRec(TreeNode node, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(node,k, list);
        return list.get(k-1);
    }

    public void inOrder(TreeNode node, int k, List<Integer> list){

        if(node==null)
            return;

        inOrder(node.left,k,list);
        list.add(node.val);
        if(list.size()==k)
            return;

        inOrder(node.right, k, list);
    }

    public int kthSmallestIterative(TreeNode node, int k){


        Stack<TreeNode> stack = new Stack<>();
        int i = 0;

        TreeNode curr = node;

        while(curr!=null || !stack.isEmpty()){

            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            i++;

            if(i==k){
                return curr.val;
            }
            curr = curr.right;
        }
        return curr.val;
    }
}
