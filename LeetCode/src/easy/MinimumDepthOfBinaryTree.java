package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {


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
 
    public int minDepth(TreeNode root) {

        if(root==null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;

            for(int i=0;i<size; i++){
                TreeNode node = queue.poll();

                if(node.left==null && node.right==null)
                    return depth;

                if(node.left!=null)
                    queue.offer(node.left);

                if(node.right!=null)
                    queue.offer(node.right);
            }
        }

        return depth;

    }


    public int minDepthDFS(TreeNode root){


        if(root==null)
            return 0;

        if(root.left==null && root.right==null){
            return 1;
        }

        int dl = Integer.MAX_VALUE;
        int dr = Integer.MAX_VALUE;

        if(root.left!=null){
            dl = minDepth(root.left);
        }

        if(root.right!=null){
            dr = minDepth(root.right);
        }
        return 1 + Math.min(dl,dr);

    }
}
