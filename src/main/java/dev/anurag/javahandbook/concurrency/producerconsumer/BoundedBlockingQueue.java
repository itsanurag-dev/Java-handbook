package dev.anurag.javahandbook.concurrency.producerconsumer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * A thread-safe bounded FIFO queue implemented using Java's intrinsic monitor lock
 * ({@code synchronized}, {@code wait()}, and {@code notifyAll()}).
 *
 * <p>Invariant: The queue size never exceeds {@code capacity}.
 * All operations block when full (put) or empty (take) until space or elements become available.</p>
 *
 * @param <E> element type
 */
public class BoundedBlockingQueue<E> {

    private final int capacity;
    private final Queue<E> queue;

    public BoundedBlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive: " + capacity);
        }
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(E element) throws InterruptedException {
        Objects.requireNonNull(element, "Cannot enqueue null element");
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(element);
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        E item = queue.poll();
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }

    public int capacity() {
        return capacity;
    }
}

