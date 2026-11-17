package dev.anurag.javahandbook.oop.creational;

import java.io.Serializable;

/**
 * Demonstrates thread-safe Singleton design patterns in modern Java:
 * <ol>
 *   <li><b>Double-Checked Locking (DCL):</b> Requires {@code volatile} for JMM happens-before semantics to prevent instruction reordering.</li>
 *   <li><b>Bill Pugh Holder Idiom:</b> Lazy initialization leveraging class-loader initialization safety (Zero sync overhead).</li>
 *   <li><b>Enum Singleton:</b> Effective Java recommendation; immune to reflection and serialization attacks.</li>
 * </ol>
 */
public final class ThreadSafeSingleton {

    private ThreadSafeSingleton() {}

    /**
     * Variant 1: Double-Checked Locking with {@code volatile}.
     */
    public static final class DoubleCheckedLocking implements Serializable {
        private static final long serialVersionUID = 1L;

        // CRITICAL: volatile establishes a happens-before relationship,
        // preventing the JVM from reordering memory allocation and object construction.
        private static volatile DoubleCheckedLocking instance;

        private DoubleCheckedLocking() {
            // Defend against reflection attacks
            if (instance != null) {
                throw new IllegalStateException("Singleton already instantiated");
            }
        }

        public static DoubleCheckedLocking getInstance() {
            DoubleCheckedLocking localRef = instance; // Local read optimization
            if (localRef == null) {
                synchronized (DoubleCheckedLocking.class) {
                    localRef = instance;
                    if (localRef == null) {
                        instance = localRef = new DoubleCheckedLocking();
                    }
                }
            }
            return localRef;
        }

        // Defend against deserialization duplication
        private Object readResolve() {
            return getInstance();
        }
    }

    /**
     * Variant 2: Bill Pugh Holder Pattern (Initialization-on-Demand).
     */
    public static final class BillPughSingleton {
        private BillPughSingleton() {}

        // The Holder class is not loaded until getInstance() is called
        private static class Holder {
            private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        }

        public static BillPughSingleton getInstance() {
            return Holder.INSTANCE;
        }
    }

    /**
     * Variant 3: Enum Singleton (Effective Java Item 3).
     */
    public enum EnumSingleton {
        INSTANCE;

        public String getConfiguration() {
            return "Production-Config";
        }
    }
}

