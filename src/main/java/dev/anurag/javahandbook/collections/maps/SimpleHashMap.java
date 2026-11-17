package dev.anurag.javahandbook.collections.maps;

import java.util.Objects;

/**
 * A pedagogical implementation of a simplified hash map demonstrating core {@link java.util.HashMap} mechanics:
 * <ul>
 *   <li>Bucket array indexed via bitwise masking: {@code (capacity - 1) & hash}</li>
 *   <li>Power-of-two capacity requirements</li>
 *   <li>Singly-linked collision chaining</li>
 *   <li>Dynamic rehashing upon exceeding the load factor threshold</li>
 * </ul>
 *
 * @param <K> key type
 * @param <V> value type
 */
public class SimpleHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] table;
    private int size;
    private final float loadFactor;
    private int threshold;

    public static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @SuppressWarnings("unchecked")
    public SimpleHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive: " + initialCapacity);
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Load factor must be positive: " + loadFactor);
        }
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        this.loadFactor = loadFactor;
        this.table = (Node<K, V>[]) new Node[capacity];
        this.threshold = (int) (capacity * loadFactor);
    }

    public SimpleHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    static int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    public V put(K key, V value) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        Node<K, V> head = table[index];
        for (Node<K, V> curr = head; curr != null; curr = curr.next) {
            if (curr.hash == hash && Objects.equals(curr.key, key)) {
                V oldVal = curr.value;
                curr.value = value;
                return oldVal;
            }
        }

        Node<K, V> newNode = new Node<>(hash, key, value, head);
        table[index] = newNode;
        size++;

        if (size > threshold) {
            resize();
        }
        return null;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        for (Node<K, V> curr = table[index]; curr != null; curr = curr.next) {
            if (curr.hash == hash && Objects.equals(curr.key, key)) {
                return curr.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        Node<K, V> prev = null;
        Node<K, V> curr = table[index];

        while (curr != null) {
            if (curr.hash == hash && Objects.equals(curr.key, key)) {
                if (prev == null) {
                    table[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        for (Node<K, V> curr = table[index]; curr != null; curr = curr.next) {
            if (curr.hash == hash && Objects.equals(curr.key, key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return table.length;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = table.length << 1;
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCapacity];
        threshold = (int) (newCapacity * loadFactor);

        for (Node<K, V> head : table) {
            Node<K, V> curr = head;
            while (curr != null) {
                Node<K, V> next = curr.next;
                int newIndex = (newCapacity - 1) & curr.hash;
                curr.next = newTable[newIndex];
                newTable[newIndex] = curr;
                curr = next;
            }
        }
        this.table = newTable;
    }
}

