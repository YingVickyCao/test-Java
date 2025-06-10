package todo.lru_cache.v3;

import java.util.HashMap;

// https://developer.aliyun.com/article/1595190


public class LRUCache<K, V> {
    static class Node<K, V> {
        K k;
        V v;
        Node<K, V> prev;
        Node<K, V> next;
    }

    int size;
    HashMap<K, Node<K, V>> map = new HashMap<>();
    Node<K, V> tail;
    Node<K, V> head;

    public LRUCache(int size) {
        this.size = size;
        head = new Node<K, V>();
        tail = new Node<K, V>();
        head.next = tail;
        tail.prev = head;
    }

    V get(K k) {
        /*
         * if(key existed){
         *      move the node to head
         *      return the value
         * }
         * else {
         *      return null
         * }
         */
        if (!map.containsKey(k)) {
            return null;
        }
        Node<K, V> node = map.get(k);
        // move to head
        moveToHead(node);
        return node.v;
    }

    void put(K k, V v) {
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
        if (map.containsKey(k)) {
            Node<K, V> node = map.get(k);
            // move to head
            moveToHead(node);
        } else {
            Node<K, V> node = new Node<>();
            node.k = k; // TODO: easy to forget
            node.v = v; // TODO: easy to forget
            map.put(k, node);
            // add the head
            addToHead(node); // TODO: easy to forget
            if (map.size() > size) {
                // remove tail
                Node<K, V> n = removeTail();
                map.remove(n.k); // TODO: easy to forget
            }
        }
    }


    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K, V> y) {
        // x, y, z
        Node<K, V> x = y.prev;
        Node<K, V> z = y.next;
        x.next = z;
        z.prev = x;
    }

    private void addToHead(Node<K, V> node) {
        // 0
        Node<K, V> n0 = head.next;
        head.next = node;

        node.prev = head;
        node.next = n0;

        n0.prev = node;
    }

    private Node<K, V> removeTail() {
        Node<K, V> n = tail.prev;
        Node<K, V> n_1 = tail.prev.prev;
        n_1.next = tail;
        tail.prev = n_1;
        return n;
    }

    void print() {
        Node<K, V> t = head;
        while (t.next != null) {
            if (t.next.k != null) {
                System.out.print(t.next.k + " ");
            }
            t = t.next;
        }
        System.out.println();
    }
}
