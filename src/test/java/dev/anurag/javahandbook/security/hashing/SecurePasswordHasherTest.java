package dev.anurag.javahandbook.security.hashing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SecurePasswordHasherTest {

    @Test
    @DisplayName("Hash should produce unique salted hashes for identical passwords")
    void hashingProducesUniqueSaltedTokens() {
        char[] password = "MasterSecretPassword#2026".toCharArray();

        String hash1 = SecurePasswordHasher.hashPassword(password);
        String hash2 = SecurePasswordHasher.hashPassword(password);

        assertThat(hash1).isNotEqualTo(hash2); // Different salts guarantee unique hash tokens
        assertThat(SecurePasswordHasher.verifyPassword(password, hash1)).isTrue();
        assertThat(SecurePasswordHasher.verifyPassword(password, hash2)).isTrue();
    }

    @Test
    @DisplayName("Verification should reject wrong passwords")
    void verificationRejectsIncorrectPassword() {
        char[] correctPassword = "CorrectPassword123".toCharArray();
        char[] wrongPassword = "WrongPassword456".toCharArray();

        String token = SecurePasswordHasher.hashPassword(correctPassword);

        assertThat(SecurePasswordHasher.verifyPassword(correctPassword, token)).isTrue();
        assertThat(SecurePasswordHasher.verifyPassword(wrongPassword, token)).isFalse();
    }

    @Test
    @DisplayName("Verification should reject corrupted hash tokens")
    void verificationRejectsCorruptedTokens() {
        char[] password = "SecretPass".toCharArray();
        String validToken = SecurePasswordHasher.hashPassword(password);

        assertThat(SecurePasswordHasher.verifyPassword(password, "corrupted:token")).isFalse();
        assertThat(SecurePasswordHasher.verifyPassword(password, "invalidToken")).isFalse();
    }
}

