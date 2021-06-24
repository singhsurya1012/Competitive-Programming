package medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

    }
    public Map<Integer,Node> cache;
    int capacity;
    Node head;
    Node tail;


    public LRUCache(int capacity){
        this.capacity = capacity;
        cache  = new HashMap<>(capacity);
        head = null;
        tail = null;
    }

    public int get(int key) {

        if(!cache.containsKey(key))
            return -1;

        Node n = cache.get(key);
        moveNodeToFront(n);
        return n.val;
    }


    public void moveNodeToFront(Node n){

        if(n==head){
            return ;
        }

        if(n==tail){
            removeTail();
        }else{
            removeNode(n);
        }
        addToHead(n);
    }

    private void removeNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addToHead(Node n) {
        n.next = head;
        head.prev = n;
        head = n;
    }

    private void removeTail() {
        tail = tail.prev;
        tail.next = null;
    }


    public void put(int key, int value) {

        if(cache.containsKey(key)){
            Node n = cache.get(key);
            n.val = value;
            moveNodeToFront(n);
            return;
        }

        if(cache.size()==capacity){
            cache.remove(tail.key);
            if(head==tail){
                head=null;
                tail=null;
            }else{
                removeTail();
            }
        }

        Node n = new Node(key,value);
        cache.put(key,n);

        if(head==null){
            head=tail=n;
        }else{
            addToHead(n);
        }
    }

   /*

   public Map<Integer,Integer> cache;
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache  = new LinkedHashMap<>(capacity);
    }

   public int get(int key) {
        if(cache.containsKey(key)){
            int value = cache.get(key);
            update(key,value);
            return value;
        }
        return -1;
    }

    private void update(int key, int value) {
        cache.remove(key);
        put(key,value);
    }

    public void put(int key, int value) {

        if(cache.containsKey(key)){
            update(key,value);
        }else if(cache.size()<this.capacity){
            cache.put(key,value);
        }else{
            Integer leastRecentlyUsed = cache.keySet().stream().findFirst().get();
            cache.remove(leastRecentlyUsed);
            cache.put(key,value);
        }
    }*/
}
