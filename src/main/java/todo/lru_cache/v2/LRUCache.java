package todo.lru_cache.v2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// 使用LinkHashMap来实现
class LRUCache<K, V> {
    private LinkedHashMap<K, V> map = new LinkedHashMap<>();

    LRUCache(int cacheSize) {
        map = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return map.size() > cacheSize;
            }
        };
    }

    void put(K key, V v) {
        map.put(key, v);
    }

    Set<K> keySet() {
        return map.keySet();
    }
}
