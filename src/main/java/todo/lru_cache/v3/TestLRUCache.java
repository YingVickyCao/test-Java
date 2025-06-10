package todo.lru_cache.v3;

public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache<String, Integer> test = new LRUCache<>(3);
        test.put("1", 1);
//        System.out.println(test.keySet()); // [1]
        test.print();

        test.put("2", 2); // [2, 1]
//        System.out.println(test.keySet());
        test.print();

        test.put("3", 3);
//        System.out.println(test.keySet()); // [3, 2, 1]
        test.print();

        test.put("4", 4);
//        System.out.println(test.keySet()); // [4, 3, 2, 1] ->  [4, 3, 2]
        test.print();

        test.put("2", 2);
//        System.out.println(test.keySet()); // [2, 4, 3]
        test.print();
    }
}
