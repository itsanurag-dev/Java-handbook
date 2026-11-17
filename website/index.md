---
layout: home

hero:
  name: "Modern Java Handbook"
  text: "Production Reference & Engineering Handbook"
  tagline: "A production-grade, test-driven Java reference handbook covering core fundamentals, JVM internals, robust concurrency, and modern Java 21 LTS features."
  actions:
    - theme: brand
      text: "Concurrency & Loom"
      link: /concurrency/virtualthreads/virtualthreadsdemo
    - theme: alt
      text: "Modern Java 21"
      link: /modern/recordsandsealed/paymentdomain
    - theme: alt
      text: "Collections Internals"
      link: /collections/maps/simplehashmap

features:
  - title: "Java 21 LTS Ready"
    details: "Project Loom Virtual Threads, Record Patterns, Sealed Hierarchies, Exhaustive Pattern Matching, and Modern Type Inference."
  - title: "Robust Concurrency & JMM"
    details: "Monitor Synchronization, Double-Checked Locking with volatile, Bounded Blocking Queues, CompletableFuture Async Pipelines, and Deadlock Detection."
  - title: "Collections Deep Dive"
    details: "Hand-crafted SimpleHashMap with bitmask indexing & dynamic rehashing, custom LRU cache, and fail-fast vs fail-safe iterators."
  - title: "Language Foundations"
    details: "Class and static initialization order, canonical equals/hashCode contract, string pool allocation, and modern java.time."
  - title: "Enterprise Persistence & Security"
    details: "Salted PBKDF2 password hashing (65,536 iterations, constant-time equality), AES-256-GCM authenticated encryption, and safe JDBC patterns."
  - title: "Deterministic Testing"
    details: "Zero flaky tests. Multi-threaded synchronization validated using JUnit 5, AssertJ, and Awaitility."
---

<div class="engineering-showcase">

## Engineering Pillars at a Glance

| Pillar | Topic / Component | Highlights | Tested with JUnit 5? |
| :--- | :--- | :--- | :---: |
| **Concurrency** | **Project Loom Virtual Threads** | Lightweight user-mode threads, carrier unmounting, 2,000+ tasks | Yes |
| **Concurrency** | **Bounded Blocking Queue** | Intrinsic monitor lock (`wait`/`notifyAll`), spurious wakeup defense | Yes |
| **Concurrency** | **Async Pipelines** | `CompletableFuture` composition, fallback exception recovery | Yes |
| **Concurrency** | **Thread-Safe Singletons** | Double-Checked Locking (DCL), Bill Pugh Holder, and Enum Singleton | Yes |
| **Modern Java** | **Sealed Types & Records** | Exhaustive domain modeling, pattern matching `switch`, compact constructors | Yes |
| **Collections** | **SimpleHashMap Internals** | Bucket bitmasking `(n - 1) & hash`, collision chaining, dynamic resize | Yes |
| **Security** | **PBKDF2 Password Hasher** | `PBKDF2WithHmacSHA256`, `SecureRandom`, constant-time `slowEquals` | Yes |
| **Fundamentals** | **Object Equality** | Canonical `equals()` and `hashCode()` contract with collision testing | Yes |

</div>

