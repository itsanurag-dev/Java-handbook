# Changelog

All notable changes to this project will be documented in this file.
The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 2026-11-17
### Added
- Maven build configuration with Java 21 LTS, Surefire, JaCoCo, and Spotless formatting.
- Deterministic test harness using JUnit 5 Jupiter, AssertJ, and Awaitility.
- Modern Project Loom Virtual Threads module (`dev.anurag.javahandbook.concurrency.virtualthreads`).
- Modern Java features module: Records, Sealed Hierarchies, Pattern Matching.
- Authenticated AES-256-GCM symmetric encryption and PBKDF2 password hashing.
- GitHub Actions CI matrix testing across Ubuntu, macOS, and Windows on JDK 17 & 21.

### Changed
- Standardized base package from `com.codex.lang.java` to `dev.anurag.javahandbook`.
- Consolidated 5 separate threading packages into a unified `concurrency` package.
- Corrected 28 misspelled classes/packages (`serilization` -> `serialization`, etc.).

### Removed
- Removed committed binary artifact `resources/serialized-object.ser`.
- Deleted insecure and broken cryptography demos (MD5, Triple-DES).
- Purged hardcoded internal corporate IP and database credentials.

