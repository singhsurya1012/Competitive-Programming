package easy;

public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();

        //preOrderRec(root,list);
        preOrderItr(root,list);
        return list;

    }

    public void preOrderItr(Node node, List<Integer> list){

        if(node==null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {

            Node curr = stack.pop();
            list.add(curr.val);

            List<Node> children = curr.children;
            for(int i=children.size()-1; i>=0; i--){
                stack.add(children.get(i));
            }
        }
    }


    public void preOrderRec(Node node, List<Integer> list){

        if(node==null){
            return;
        }

        list.add(node.val);
        for(Node n: node.children){
            preOrderRec(n,list);
        }
    }
}
