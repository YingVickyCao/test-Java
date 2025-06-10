package todo.lru_cache.v1;

// https://blog.csdn.net/jam_yin/article/details/131848532
// https://blog.csdn.net/csdlwzy/article/details/95635083
public class TestLruCache {
    public static void main(String[] args) {
        LRUCache<String, Integer> test = new LRUCache<>(3);
        test.put("1", 1);
        System.out.println(test.keySet()); // [1]

        test.put("2", 2); // [1, 2]
        System.out.println(test.keySet());

        test.put("3", 3);
        System.out.println(test.keySet()); // [1, 2, 3]

        test.put("4", 4);
        System.out.println(test.keySet()); // [2, 3, 4]

        test.put("2", 2);
        System.out.println(test.keySet()); // [3, 4, 2]
    }
}