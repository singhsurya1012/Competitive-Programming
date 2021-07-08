package medium;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {


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

    public int sumNumbers(TreeNode root) {

        if(root==null)
            return 0;

        Queue<Element> queue = new LinkedList<>();
        queue.offer(new Element(root,root.val));

        int ans = 0;
        while(!queue.isEmpty()){

            Element element = queue.poll();
            TreeNode node = element.node;
            int val = element.val;

            if(node.left==null && node.right==null){
                ans+=val;
                continue;
            }

            if(node.left!=null){
                int newVal = val*10 + node.left.val;
                queue.offer(new Element(node.left, newVal));
            }

            if(node.right!=null){
                int newVal = val*10 + node.right.val;
                queue.offer(new Element(node.right, newVal));
            }
        }

        return ans;
    }

    class Element {
        TreeNode node;
        int val;

        public Element(TreeNode node, int val){
            this.node = node;
            this.val= val;
        }
    }
}
