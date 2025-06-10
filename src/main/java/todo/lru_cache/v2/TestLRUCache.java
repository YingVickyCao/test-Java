package todo.lru_cache.v2;

public class TestLRUCache {
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
        // https://blog.csdn.net/jam_yin/article/details/131848532
    }
}

