package dev.anurag.javahandbook.concurrency.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates Project Loom Virtual Threads (Java 21 LTS):
 * <ul>
 *   <li>Creating lightweight virtual threads via {@link Thread#ofVirtual()}</li>
 *   <li>Using {@link Executors#newVirtualThreadPerTaskExecutor()} with try-with-resources</li>
 *   <li>Demonstrating massive concurrency ($10^4+$ concurrent blocking tasks) without thread pool exhaustion</li>
 * </ul>
 */
public class VirtualThreadsDemo {

    public static int runVirtualThreadTasks(int taskCount, long sleepMillis) {
        AtomicInteger completedTasks = new AtomicInteger(0);

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < taskCount; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(sleepMillis); // Non-blocking carrier unmount in virtual thread
                        completedTasks.incrementAndGet();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } // Implicit executor.close() awaits completion of all virtual thread tasks

        return completedTasks.get();
    }
}

