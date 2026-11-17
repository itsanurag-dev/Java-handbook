package dev.anurag.javahandbook.oop.creational;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

class ThreadSafeSingletonTest {

    @Test
    @DisplayName("DoubleCheckedLocking must return the exact same instance across concurrent threads")
    void doubleCheckedLockingConcurrentAccess() throws Exception {
        int threadCount = 32;
        ExecutorService pool = Executors.newFixedThreadPool(threadCount);
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(threadCount);
        List<ThreadSafeSingleton.DoubleCheckedLocking> instances = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < threadCount; i++) {
            pool.submit(() -> {
                try {
                    startGate.await();
                    instances.add(ThreadSafeSingleton.DoubleCheckedLocking.getInstance());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    endGate.countDown();
                }
            });
        }

        startGate.countDown();
        endGate.await();
        pool.shutdown();

        Set<ThreadSafeSingleton.DoubleCheckedLocking> unique = new HashSet<>(instances);
        assertThat(unique).hasSize(1);
    }

    @Test
    @DisplayName("BillPughSingleton must return the exact same instance across concurrent threads")
    void billPughConcurrentAccess() throws Exception {
        int threadCount = 32;
        ExecutorService pool = Executors.newFixedThreadPool(threadCount);
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(threadCount);
        List<ThreadSafeSingleton.BillPughSingleton> instances = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < threadCount; i++) {
            pool.submit(() -> {
                try {
                    startGate.await();
                    instances.add(ThreadSafeSingleton.BillPughSingleton.getInstance());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    endGate.countDown();
                }
            });
        }

        startGate.countDown();
        endGate.await();
        pool.shutdown();

        Set<ThreadSafeSingleton.BillPughSingleton> unique = new HashSet<>(instances);
        assertThat(unique).hasSize(1);
    }

    @Test
    @DisplayName("DoubleCheckedLocking must survive serialization without creating duplicate instance")
    void doubleCheckedLockingSerializationSafety() throws Exception {
        ThreadSafeSingleton.DoubleCheckedLocking original = ThreadSafeSingleton.DoubleCheckedLocking.getInstance();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original);
        }

        ThreadSafeSingleton.DoubleCheckedLocking deserialized;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            deserialized = (ThreadSafeSingleton.DoubleCheckedLocking) ois.readObject();
        }

        assertThat(deserialized).isSameAs(original);
    }

    @Test
    @DisplayName("EnumSingleton provides absolute singleton guarantee")
    void enumSingletonTest() {
        ThreadSafeSingleton.EnumSingleton instance1 = ThreadSafeSingleton.EnumSingleton.INSTANCE;
        ThreadSafeSingleton.EnumSingleton instance2 = ThreadSafeSingleton.EnumSingleton.INSTANCE;

        assertThat(instance1).isSameAs(instance2);
        assertThat(instance1.getConfiguration()).isEqualTo("Production-Config");
    }
}

