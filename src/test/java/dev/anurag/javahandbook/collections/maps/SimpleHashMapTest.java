package dev.anurag.javahandbook.collections.maps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleHashMapTest {

    @Test
    @DisplayName("Constructor should reject invalid capacities or load factors")
    void constructorShouldValidateInputs() {
        assertThatThrownBy(() -> new SimpleHashMap<String, String>(0, 0.75f))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new SimpleHashMap<String, String>(16, -0.5f))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Basic put, get, remove, and containsKey operations")
    void basicOperationsWorkCorrectly() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        assertThat(map.isEmpty()).isTrue();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        assertThat(map.size()).isEqualTo(3);
        assertThat(map.get("Apple")).isEqualTo(10);
        assertThat(map.get("Banana")).isEqualTo(20);
        assertThat(map.get("Orange")).isEqualTo(30);
        assertThat(map.containsKey("Banana")).isTrue();
        assertThat(map.containsKey("Grape")).isFalse();

        // Update value for existing key
        Integer old = map.put("Apple", 99);
        assertThat(old).isEqualTo(10);
        assertThat(map.get("Apple")).isEqualTo(99);
        assertThat(map.size()).isEqualTo(3);

        // Remove key
        Integer removed = map.remove("Banana");
        assertThat(removed).isEqualTo(20);
        assertThat(map.size()).isEqualTo(2);
        assertThat(map.get("Banana")).isNull();
        assertThat(map.containsKey("Banana")).isFalse();
    }

    @Test
    @DisplayName("Null key support (hash code 0, bucket 0)")
    void nullKeySupported() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(null, "NullValue");

        assertThat(map.containsKey(null)).isTrue();
        assertThat(map.get(null)).isEqualTo("NullValue");

        map.put(null, "UpdatedNull");
        assertThat(map.get(null)).isEqualTo("UpdatedNull");

        map.remove(null);
        assertThat(map.containsKey(null)).isFalse();
    }

    @Test
    @DisplayName("Hash collisions must chain into linked list without loss of data")
    void hashCollisionsHandledViaChaining() {
        // Force collision: two keys with the same hash code
        record CollidingKey(int id) {
            @Override
            public int hashCode() {
                return 42; // All keys land in same bucket
            }
        }

        SimpleHashMap<CollidingKey, String> map = new SimpleHashMap<>(4, 0.75f);
        CollidingKey k1 = new CollidingKey(1);
        CollidingKey k2 = new CollidingKey(2);
        CollidingKey k3 = new CollidingKey(3);

        map.put(k1, "First");
        map.put(k2, "Second");
        map.put(k3, "Third");

        assertThat(map.size()).isEqualTo(3);
        assertThat(map.get(k1)).isEqualTo("First");
        assertThat(map.get(k2)).isEqualTo("Second");
        assertThat(map.get(k3)).isEqualTo("Third");

        map.remove(k2);
        assertThat(map.size()).isEqualTo(2);
        assertThat(map.get(k1)).isEqualTo("First");
        assertThat(map.get(k2)).isNull();
        assertThat(map.get(k3)).isEqualTo("Third");
    }

    @Test
    @DisplayName("Map should automatically rehash and double capacity when exceeding load factor")
    void resizingPreservesAllEntries() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(4, 0.75f);
        assertThat(map.capacity()).isEqualTo(4);

        // Put 100 items to trigger multiple resize cycles (4 -> 8 -> 16 -> 32 -> 64 -> 128 -> 256)
        for (int i = 0; i < 100; i++) {
            map.put(i, "Val-" + i);
        }

        assertThat(map.size()).isEqualTo(100);
        assertThat(map.capacity()).isGreaterThanOrEqualTo(128);

        for (int i = 0; i < 100; i++) {
            assertThat(map.get(i)).isEqualTo("Val-" + i);
        }
    }
}

