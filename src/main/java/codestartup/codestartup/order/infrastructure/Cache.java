package codestartup.codestartup.order.infrastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cache<K, V> {
    private Map<K, V> cache = new HashMap<>();

    public Optional<V> get(K key) {
        return Optional.ofNullable(cache.get(key));
    }
}
