package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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
    
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        //rightSideViewBFS(root,list);
        rightSideViewDFS(root,list,0);
        return list;

    }

    public void rightSideViewBFS(TreeNode root, List<Integer> list){

        if(root==null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            list.add(queue.peek().val);

            while(size-->0){
                TreeNode node = queue.poll();

                if(node.right!=null)
                    queue.offer(node.right);

                if(node.left!=null)
                    queue.offer(node.left);

            }
        }

    }


    public void rightSideViewDFS(TreeNode node, List<Integer> list, int level){

        if(node==null)
            return;

        if(list.size()==level)
            list.add(node.val);

        rightSideViewDFS(node.right, list, level+1);
        rightSideViewDFS(node.left, list, level+1);

    }
}
