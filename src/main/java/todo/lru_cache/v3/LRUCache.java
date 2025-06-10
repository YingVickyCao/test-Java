package todo.lru_cache.v3;

import java.util.HashMap;
import java.util.Set;

// https://developer.aliyun.com/article/1595190
public class LRUCache<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    private final int capacity;
    private final HashMap<K, Node<K, V>> map;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    V get(K key) {
        /*
         * if(key existed){
         *      move the node to head
         *      return the value
         * }
         * else {
         *      return null
         * }
         */
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    void put(K key, V value) {
        /*
         * if (key not existed){
         *      // move to head
         *}
         *else{
         *      // add to head
         *      if (size max){
         *          // remove tail
         *      }
         * }
         */
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            moveToHead(node);
        } else {
            Node<K, V> node = new Node<>(key, value);
            map.put(key, node);
            addToHead(node);
            if (map.size() > capacity) {
                Node<K, V> leastNode = removeLeastNode();
                map.remove(leastNode.key);
            }
        }
    }

    void moveToHead(Node<K, V> node) {
        // remove the node
        removeNode(node);
        // add the head
        addToHead(node);
    }

    void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;

        Node<K, V> n0 = head.next;
        head.next = node;
        n0.prev = node;
    }

    Node<K, V> removeLeastNode() {
        Node<K, V> least = tail.prev;
        Node<K, V> t = tail.prev.prev;
        t.next = tail;
        tail.prev = t;
        return least;
    }

    Set<K> keySet() {
        return map.keySet();
    }

    public void print() {
        Node<K, V> t = head;
        while (t.next != null) {
            if (t.next.key !=null){
                System.out.print(t.next.key + " ");
            }
            t = t.next;
        }
        System.out.println();
    }
}
