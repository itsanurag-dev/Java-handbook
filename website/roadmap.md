# Modern Java Learning Roadmap

This roadmap organizes the modules into a progressive learning sequence:

```
1. Language Foundations
   ├── Memory semantics & Pass-by-value
   ├── Class & static initialization order
   ├── Compact Strings & String Pool
   └── Equality contracts (equals/hashCode)

2. OOP & Type Modeling
   ├── Encapsulation & access boundaries
   ├── Polymorphism & dynamic dispatch
   ├── Deep immutability patterns
   └── Modern Java (Records, Sealed Types, Pattern Matching)

3. Collections Architecture
   ├── Array vs node-based layouts & cache locality
   ├── HashMap internals, bitmask hashing & treeification
   ├── Custom LRU cache implementation
   └── Fail-fast iterators & concurrent collections

4. Concurrent Systems & JMM
   ├── Java Memory Model, volatile & safe publication
   ├── Monitor synchronization & bounded queues
   ├── Explicit locks (ReentrantLock, StampedLock)
   ├── Lock-free atomics & CAS operations
   ├── Asynchronous composition with CompletableFuture
   └── Project Loom: Virtual threads & carrier unmounting

5. Enterprise I/O, Persistence & Security
   ├── Modern NIO.2 channels & buffers
   ├── Safe serialization filters
   ├── Parameterized JDBC with connection pooling
   └── Cryptography: Authenticated AES-GCM & PBKDF2 hashing
```
