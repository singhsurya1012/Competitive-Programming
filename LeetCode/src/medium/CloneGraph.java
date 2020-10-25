package medium;

import java.util.*;

public class CloneGraph {


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    Map<Integer, Node> map = new HashMap<>();

    //Simple DFS Traversal
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node(node.val);
        map.put(node.val, clone);

        for (Node n : node.neighbors) {
            clone.neighbors.add(cloneGraph(n));
        }

        return clone;
    }


    //Simple BFS Implementation
    public Node cloneGraphBFS(Node node) {

        if(node==null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        Node clone  = new Node(node.val);
        map.put(node.val, clone);

        while(!q.isEmpty()){

            Node curr =q.poll();

            for(Node n: curr.neighbors) {

                if(!map.containsKey(n.val)) {
                    map.put(n.val, new Node(n.val));
                    q.offer(n);
                }
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return clone;
    }
}
