package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubTree {

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


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> l = new ArrayList<>();

        //We create a unique key for each node
        Map<String, Integer> map = new HashMap<>();

        DFS(root, map, l);
        return l;

    }

    public String DFS(TreeNode node, Map<String, Integer> map, List<TreeNode> l) {

        //We create a key as its InOrderTraversal
        //Null child will be represented as hash
        if (node == null)
            return "#";

        StringBuilder key = new StringBuilder();


        //We use preorder to serialize a sub tree
        key.append(node.val + ",");
        key.append(DFS(node.left, map, l) + ",");
        key.append(DFS(node.right, map, l));

        String k = key.toString();

        //If we have seen this key means we have encountered it before
        //So we increment the number of times we have encountered this key
        map.put(k, map.getOrDefault(k, 0) + 1);

        //We only add the current node once the number of times we have seen is 2
        if (map.get(k) == 2)
            l.add(node);

        return k;
    }

}
