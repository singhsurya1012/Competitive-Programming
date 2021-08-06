package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

    class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new LinkedList<>();

        if(root==null){
            return result;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> list = new LinkedList<>();

            Node n = null;
            while(size-->0){

                n = q.poll();
                list.add(n.val);

                for(Node child: n.children){
                    q.offer(child);
                }
            }
            result.add(list);
        }

        return result;
    }
}
