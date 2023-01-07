package LinkedList;

import java.util.HashMap;

public class LRUCache {
    private static class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int _key, int _val){
            key = _key;
            val = _val;
            prev = null;
            next = null;
        }
    }
    private final int capacity;
    private int size;
    private Node head;
    private Node tail;
    private final HashMap<Integer, Node> map;

    public LRUCache(int _capacity){
        capacity = _capacity;
        size = 0;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            Node temp = map.get(key);
            // move to tail
            moveToTail(temp);
            return temp.val;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.val = value;

            // move it to tail
            moveToTail(temp);

        }else {
            Node newNode = new Node(key, value);
            if (size < capacity) {
                map.put(key, newNode);
                // add to tail
                addToTail(newNode);
                // in case it is a first element in cache, then head will be null
                // we have to make head point to first Node
                if (head == null) head = tail;
                size++;
            }else {
                // deleting first element in cache from map
                map.remove(head.key);

                // adding new key to map
                map.put(key, newNode);

                head = head.next;
                if (head == null) {
                    tail = null;
                    addToTail(newNode);
                    head = tail;
                }
                addToTail(newNode);
                head.prev = null; // why it is necessary? because first node wasn't remove until there is a reference to it
                // (garbage collection)
            }
        }
    }

    private void addToTail(Node node) {
        if (tail == null) tail = node; // if tail is null which means no element in cache
        else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
            tail.next = null;
        }
    }

    private void moveToTail(Node node) {
        if (size > 1) {
            Node prevNode = node.prev; // previous node of selected node
            Node nextNode = node.next; // next node of selected node

            // as we are specifically defined that size should be greater than 1
            // that means there will at least one either prev or next node of selected node
            if (prevNode == null) {
                // this means that selected node is head node
                // we have to update head reference
                head = head.next;
                // now add selected node to tail
                addToTail(node);
                head.prev = null;
            }else if (nextNode != null) {
                // why next shouldn't be null? because if next is null that means selected node is tail node
                // so there is no meaning to shift tail node to tail XD

                // linking of next and prev node of selected node
                prevNode.next = nextNode;
                nextNode.prev = prevNode;

                // now add selected node to tail
                addToTail(node);
            }
        }
    }
}
