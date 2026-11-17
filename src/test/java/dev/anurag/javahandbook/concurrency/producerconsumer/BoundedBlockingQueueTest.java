package dev.anurag.javahandbook.concurrency.producerconsumer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.awaitility.Awaitility.await;

class BoundedBlockingQueueTest {

    @Test
    @DisplayName("Constructor should reject zero or negative capacity")
    void constructorShouldRejectInvalidCapacity() {
        assertThatThrownBy(() -> new BoundedBlockingQueue<Integer>(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BoundedBlockingQueue<Integer>(-5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Put should reject null elements")
    void putShouldRejectNullElements() {
        BoundedBlockingQueue<String> queue = new BoundedBlockingQueue<>(2);
        assertThatThrownBy(() -> queue.put(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Take should block until an element is put into an empty queue")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void takeShouldBlockUntilElementAvailable() throws InterruptedException {
        BoundedBlockingQueue<Integer> queue = new BoundedBlockingQueue<>(3);
        CountDownLatch threadStarted = new CountDownLatch(1);
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());

        Thread consumer = new Thread(() -> {
            try {
                threadStarted.countDown();
                result.add(queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        threadStarted.await();

        await().atMost(Duration.ofSeconds(1))
                .until(() -> consumer.getState() == Thread.State.WAITING);

        assertThat(result).isEmpty();

        queue.put(42);

        await().atMost(Duration.ofSeconds(1))
                .until(() -> !result.isEmpty());

        assertThat(result).containsExactly(42);
        consumer.join();
    }

    @Test
    @DisplayName("Put should block when queue is full")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void putShouldBlockWhenQueueIsFull() throws Exception {
        BoundedBlockingQueue<String> queue = new BoundedBlockingQueue<>(2);
        queue.put("Element-1");
        queue.put("Element-2");

        assertThat(queue.size()).isEqualTo(2);

        AtomicBoolean putCompleted = new AtomicBoolean(false);
        Thread producer = new Thread(() -> {
            try {
                queue.put("Element-3");
                putCompleted.set(true);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();

        await().atMost(Duration.ofSeconds(1))
                .until(() -> producer.getState() == Thread.State.WAITING);

        assertThat(putCompleted.get()).isFalse();

        String removed = queue.take();
        assertThat(removed).isEqualTo("Element-1");

        await().atMost(Duration.ofSeconds(1))
                .untilTrue(putCompleted);

        assertThat(queue.size()).isEqualTo(2);
        producer.join();
    }

    @Test
    @DisplayName("Concurrent multi-producer multi-consumer stress test must preserve data integrity")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void concurrentStressTestMustPreserveIntegrity() throws Exception {
        final int capacity = 10;
        final int itemsPerProducer = 200;
        final int producerCount = 4;
        final int totalItems = itemsPerProducer * producerCount;
        final int consumerCount = 4;

        BoundedBlockingQueue<Integer> queue = new BoundedBlockingQueue<>(capacity);
        List<Integer> consumedItems = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(producerCount + consumerCount);

        try (ExecutorService pool = Executors.newFixedThreadPool(producerCount + consumerCount)) {
            for (int p = 0; p < producerCount; p++) {
                final int start = p * itemsPerProducer;
                pool.submit(() -> {
                    try {
                        startGate.await();
                        for (int i = 0; i < itemsPerProducer; i++) {
                            queue.put(start + i);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        doneLatch.countDown();
                    }
                });
            }

            final int itemsPerConsumer = totalItems / consumerCount;
            for (int c = 0; c < consumerCount; c++) {
                pool.submit(() -> {
                    try {
                        startGate.await();
                        for (int i = 0; i < itemsPerConsumer; i++) {
                            consumedItems.add(queue.take());
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        doneLatch.countDown();
                    }
                });
            }

            startGate.countDown();
            boolean completed = doneLatch.await(8, TimeUnit.SECONDS);

            assertThat(completed).isTrue();
            assertThat(consumedItems).hasSize(totalItems);
            assertThat(queue.size()).isZero();
        }
    }
}

