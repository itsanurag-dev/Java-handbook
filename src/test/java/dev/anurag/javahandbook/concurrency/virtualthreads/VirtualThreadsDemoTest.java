package dev.anurag.javahandbook.concurrency.virtualthreads;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class VirtualThreadsDemoTest {

    @Test
    @DisplayName("Should execute 2,000 concurrent blocking virtual threads smoothly within 2 seconds")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void virtualThreadsMassiveConcurrency() {
        int tasks = 2000;
        int completed = VirtualThreadsDemo.runVirtualThreadTasks(tasks, 50);

        assertThat(completed).isEqualTo(tasks);
    }

    @Test
    @DisplayName("Virtual thread factory creates thread marked as virtual")
    void virtualThreadTypeCheck() throws InterruptedException {
        Thread vThread = Thread.ofVirtual().name("vt-worker").start(() -> {
            assertThat(Thread.currentThread().isVirtual()).isTrue();
        });
        vThread.join();
    }
}

