# Modern Java Handbook

[![Build Status](https://github.com/itsanurag-dev/Java-handbook/actions/workflows/pages.yml/badge.svg)](https://github.com/itsanurag-dev/Java-handbook/actions)
[![Documentation Portal](https://img.shields.io/badge/docs-GitHub%20Pages-blue.svg)](https://itsanurag-dev.github.io/Java-handbook/)
[![Java 21 LTS](https://img.shields.io/badge/Java-21%20LTS-orange.svg)](https://openjdk.org/projects/jdk/21/)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](CONTRIBUTING.md)

> An engineering reference, concurrency deep-dive, and senior interview preparation handbook covering core JVM mechanics, modern Java 21 LTS features, and test-driven architecture.

📖 **Live Web Portal & Documentation:** [https://itsanurag-dev.github.io/Java-handbook/](https://itsanurag-dev.github.io/Java-handbook/)

---

## Architecture & Topic Directory

* [**Modern Java 21**](src/main/java/dev/anurag/javahandbook/modern): Algebraic Data Types via `sealed interface`, immutable `record` types, and exhaustive pattern matching `switch`.
* [**Concurrency & Multithreading**](src/main/java/dev/anurag/javahandbook/concurrency): Project Loom virtual threads, monitor synchronization (`synchronized`, `wait()`, `notifyAll()`), explicit locks (`ReentrantLock`), `CompletableFuture` async pipelines, bounded blocking queues, and deadlock detection.
* [**Collections Framework**](src/main/java/dev/anurag/javahandbook/collections): `SimpleHashMap` internals (bitmask hashing `(n - 1) & hash`, dynamic rehashing, collision chaining), custom LRU caches, fail-fast iterators, and `Comparable`/`Comparator` sorting.
* [**Object-Oriented Design**](src/main/java/dev/anurag/javahandbook/oop): Thread-safe singleton patterns (Double-Checked Locking with `volatile`, Bill Pugh Holder, Enum Singleton), deep immutability, polymorphic dispatch, and encapsulation.
* [**Language Fundamentals**](src/main/java/dev/anurag/javahandbook/fundamentals): Class and static initialization order, memory semantics, equality contracts (`equals`/`hashCode`), string pool mechanics, and `java.time`.
* [**Security & Cryptography**](src/main/java/dev/anurag/javahandbook/security): Salted `PBKDF2WithHmacSHA256` password hashing (65,536 iterations, constant-time `slowEquals` against timing attacks), and authenticated AES-256-GCM encryption.
* [**I/O, Persistence & Exceptions**](src/main/java/dev/anurag/javahandbook/io): Modern NIO.2 channels, serialization best practices, and parameterized JDBC queries.
* [**Interview Algorithms**](src/main/java/dev/anurag/javahandbook/interview): Algorithmic interview problems with time/space complexity analysis and automated unit test assertions.

---

## Getting Started

### Prerequisites
- **JDK 21 LTS** or newer (OpenJDK, Temurin, or Oracle JDK)
- **Apache Maven 3.9+**
- **Node.js 18+** (for the VitePress documentation portal)

### Build and Verify
Compile the entire project and run all deterministic test suites:
```bash
mvn clean test
```

### Running the Documentation Portal Locally
```bash
cd website
npm install
npm run docs:dev
```
Open [http://localhost:5173/Java-handbook/](http://localhost:5173/Java-handbook/) to browse the interactive portal.

### Running a Specific Interactive Demo
Every module includes runnable classes with structured console execution:
```bash
# Producer-Consumer Bounded Queue Demo
mvn compile exec:java -Dexec.mainClass="dev.anurag.javahandbook.concurrency.producerconsumer.BoundedBlockingQueue"

# Project Loom Virtual Threads Demo
mvn compile exec:java -Dexec.mainClass="dev.anurag.javahandbook.concurrency.virtualthreads.VirtualThreadsDemo"
```

---

## Learning Path

Follow the structured [Curriculum Roadmap](docs/roadmap.md) to navigate from foundational JVM concepts to advanced concurrent and distributed primitives.

---

## Contributing & Code Style
Please review [CONTRIBUTING.md](CONTRIBUTING.md) and [CHANGELOG.md](CHANGELOG.md) before submitting pull requests. All contributions must compile cleanly with `mvn test` and maintain automated JUnit 5 coverage.
