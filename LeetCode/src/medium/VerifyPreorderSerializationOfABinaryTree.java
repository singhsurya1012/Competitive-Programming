package medium;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) {

        String[] nodes = preorder.split(",");

        int openPositions = 1;
        for(String n: nodes){

            openPositions--;
            if(openPositions<0)
                return false;

            if(!n.equals("#"))
                openPositions+=2;
        }

        return openPositions==0;


    }

    public boolean isValidSerializationFullBinaryTree(String preorder) {

        String[] nodes = preorder.split(",");

        int leaves = 0;
        int nonLeaves = 0;
        int i = 0;
        for(i=0; i<nodes.length && nonLeaves+1!=leaves; i++){

            if(nodes[i].equals("#"))
                leaves++;
            else
                nonLeaves++;
        }

        return i==nodes.length && nonLeaves+1==leaves;


    }

    public boolean isValidSerializationStack(String preorder) {

        String[] nodes = preorder.split(",");

        Stack<String> stack = new Stack<>();

        String prev = null;
        for(String n : nodes){

            if(stack.isEmpty()){
                stack.push(n);
                prev = n;
                continue;
            }else{
                prev = stack.peek();
                stack.push(n);
            }

            while(null!=prev && prev.equals("#") && stack.peek().equals("#")){

                stack.pop();
                stack.pop();
                if(stack.isEmpty()){
                    return false;
                }

                String top = stack.pop();
                if(top.equals("#"))
                    return false;

                prev = stack.isEmpty() ? null:stack.peek();
                stack.push("#");
            }

        }

        return stack.isEmpty() || stack.size()>1?false: stack.pop().equals("#");
    }
}
