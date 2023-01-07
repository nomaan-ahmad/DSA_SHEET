package LinkedList;

// https://leetcode.com/problems/lru-cache/description/

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

    // get method will return val corresponding to key if present
    // and also make particular key as most recently used key by moving it to tail
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            Node temp = map.get(key);
            // move to tail
            moveToTail(temp);
            return temp.val;
        }
    }

    // put will add new key val to the cache
    // 1. if capacity is full then it will delete, least recently used key
    // 2. if capacity is not full then add the key to tail of the cache
    // 3. if the key is already present in the cache then update the node corresponding to key and move it to the tail
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // if key is already present in the cache
            Node temp = map.get(key);
            temp.val = value;

            // move it to tail
            moveToTail(temp);

        }else {
            // if key is not present
            Node newNode = new Node(key, value);
            if (size < capacity) {
                // if there is space in cache (capacity is not full)
                map.put(key, newNode);
                // add to tail
                addToTail(newNode);
                // in case it is a first element in cache, then head will be null
                // we have to make head point to first Node
                if (head == null) head = tail;
                size++;
            }else {
                // capacity is full
                // deleting first element in cache from map
                map.remove(head.key);

                // adding new key to map
                map.put(key, newNode);

                // deleting first node by incrementing head reference
                head = head.next;
                if (head == null) {
                    // if head is null that means that was only one element in cache
                    tail = null; // we made tail=null, because there is no element in cache
                    addToTail(newNode);
                    head = tail;
                }
                addToTail(newNode);
                // (garbage collection) head->prev is still pointing to the deleted node
                head.prev = null; // why it is necessary? because first node wasn't remove until there is a reference to it
            }
        }
    }

    private void addToTail(Node node) {
        if (tail == null) tail = node; // if tail is null which means no element in cache
        else {
            // basic reference connection
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
