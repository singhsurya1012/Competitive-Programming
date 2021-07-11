package hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    class MedianFinder {

        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        /** initialize your data structure here. */
        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {

            if(left.size()==right.size()){
                right.offer(num);
                left.offer(right.poll());
            }else{
                left.offer(num);
                right.offer(left.poll());
            }

        }

        public double findMedian() {

            if(left.size()==right.size()){
                return (left.peek()+right.peek())/2.0;
            }

            return left.peek();
        }
    }



    class MedianFinderBST {

        /** initialize your data structure here. */
        int size = 0;
        Node root;

        public MedianFinderBST() {
            root = null;
            size = 0;
        }

        public void addNum(int num) {

            root = addNode(root, num);
            size++;

        }

        private Node addNode(Node node, int num) {

            if(node ==null){
                return new Node(num);
            }

            if(num<node.val){
                node.leftTreeSize++;
                node.left = addNode(node.left, num);
            }else{
                node.right = addNode(node.right,num);
            }

            return node;

        }

        public double findMedian() {

            int mid = 0;

            mid+= find(root,size/2);

            if(size%2==0){
                mid+= find(root,size/2 -1);
                return (double) mid / 2;
            }

            return mid;
        }


        private int find(Node node, int size){

            if(node.leftTreeSize>size){
                return find(node.left,size);
            }

            if(size==node.leftTreeSize){
                return node.val;
            }

            size-= (node.leftTreeSize+1);
            return find(node.right,size);

        }
    }

    class Node {

        int val;
        int leftTreeSize;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.leftTreeSize = 0;
        }

    }
}
