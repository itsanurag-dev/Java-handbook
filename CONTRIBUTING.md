# Contributing to Modern Java Handbook

Thank you for helping build a first-class Java engineering handbook! To keep this repository authoritative, clean, and maintainable, we adhere to strict architectural rules.

## Standards for Every Contribution
1. **Target Java 21 LTS**: Use modern idioms (records, pattern matching, `var` where readable, modern `java.time`, virtual threads). Avoid legacy APIs (`Vector`, `Hashtable`, `Date`, `SimpleDateFormat`).
2. **Every Feature Must Have a Test**: Pull requests adding code without automated JUnit 5 tests will not be merged.
3. **No Flaky Concurrency Tests**:
   - Never use `Thread.sleep()` to assert asynchronous conditions.
   - Use `CountDownLatch`, `CompletableFuture`, or `Awaitility.await()`.
4. **Clean Code Style**:
   - Run `mvn spotless:apply` before committing.
   - All classes must have descriptive class-level Javadoc.
5. **No Committed Binaries**:
   - Never commit `.class`, `.jar`, `.ser`, or binary test fixtures. Generate test fixtures programmatically inside JUnit tests using `@TempDir`.

## Development Workflow
```bash
# 1. Fork and clone the repository
git checkout -b feature/my-new-topic

# 2. Make your edits and ensure formatting matches
mvn spotless:apply

# 3. Verify compilation and run all tests
mvn clean verify

# 4. Commit using Conventional Commits
git commit -m "feat(concurrency): add StampedLock optimistic read demonstration"
```

