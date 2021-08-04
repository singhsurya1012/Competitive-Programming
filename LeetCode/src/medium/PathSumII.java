package medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

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

    List<List<Integer>> result  = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root==null)
            return result;

        List<Integer> list = new ArrayList<>();

        dfs(root,0,targetSum,list);
        return result;
    }


    public void dfs(TreeNode node, int sum, int targetSum, List<Integer> list){

        list.add(node.val);
        sum+=node.val;

        if(node.left==null && node.right==null){

            if(sum==targetSum){
                result.add(new ArrayList<>(list));
            }

            list.remove(list.size()-1);
            sum-=node.val;

            return;

        }

        if(node.left!=null){
            dfs(node.left,sum,targetSum,list);
        }

        if(node.right!=null){
            dfs(node.right,sum,targetSum,list);
        }

        list.remove(list.size()-1);
        sum-=node.val;

    }
}
