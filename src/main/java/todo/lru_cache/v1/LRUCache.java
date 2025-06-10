package todo.lru_cache.v1;

import java.util.LinkedHashMap;
import java.util.Map;

// https://blog.csdn.net/jam_yin/article/details/131848532
// https://blog.csdn.net/csdlwzy/article/details/95635083
// 使用LinkHashMap来实现
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize = 0;

    LRUCache(int cacheSize) {
        // 0.75 = the load factor for the hash table.
        super(cacheSize, 0.75F, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
