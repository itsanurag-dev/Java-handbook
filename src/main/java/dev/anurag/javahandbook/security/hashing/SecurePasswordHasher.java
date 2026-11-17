package dev.anurag.javahandbook.security.hashing;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Objects;

/**
 * Production-grade password hashing implementation using PBKDF2WithHmacSHA256:
 * <ul>
 *   <li>Cryptographically secure pseudo-random number generator (CSPRNG) for salting</li>
 *   <li>65,536 iterations to thwart GPU/ASIC brute-force attacks</li>
 *   <li>Constant-time comparison method ({@link #slowEquals}) to prevent timing side-channel attacks</li>
 * </ul>
 */
public final class SecurePasswordHasher {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 65_536;
    private static final int KEY_LENGTH = 256;
    private static final int SALT_BYTES = 16;

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private SecurePasswordHasher() {}

    /**
     * Hashes a password using PBKDF2 with a randomly generated 16-byte salt.
     *
     * @param password raw password characters (cleared in caller after use)
     * @return encoded string formatted as: iterations:base64(salt):base64(hash)
     */
    public static String hashPassword(char[] password) {
        Objects.requireNonNull(password, "Password cannot be null");
        byte[] salt = new byte[SALT_BYTES];
        SECURE_RANDOM.nextBytes(salt);

        byte[] hash = pbkdf2(password, salt, ITERATIONS, KEY_LENGTH);

        Base64.Encoder encoder = Base64.getEncoder();
        return ITERATIONS + ":" + encoder.encodeToString(salt) + ":" + encoder.encodeToString(hash);
    }

    /**
     * Verifies a candidate password against an encoded hash token.
     *
     * @param password candidate password
     * @param storedHash stored token formatted as: iterations:base64(salt):base64(hash)
     * @return true if password matches, false otherwise
     */
    public static boolean verifyPassword(char[] password, String storedHash) {
        Objects.requireNonNull(password, "Password cannot be null");
        Objects.requireNonNull(storedHash, "Stored hash cannot be null");

        String[] parts = storedHash.split(":");
        if (parts.length != 3) {
            return false;
        }

        int iterations = Integer.parseInt(parts[0]);
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] salt = decoder.decode(parts[1]);
        byte[] expectedHash = decoder.decode(parts[2]);

        byte[] candidateHash = pbkdf2(password, salt, iterations, expectedHash.length * 8);

        // Constant-time equality check defends against timing side-channel attacks
        return slowEquals(candidateHash, expectedHash);
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLength) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IllegalStateException("Failed to hash password with algorithm: " + ALGORITHM, e);
        }
    }

    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }
}

