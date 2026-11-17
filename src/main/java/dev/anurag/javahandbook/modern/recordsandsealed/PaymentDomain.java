package dev.anurag.javahandbook.modern.recordsandsealed;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Demonstrates modern Java domain modeling using Sealed Hierarchies, Records,
 * and Pattern Matching for Switch (Java 17 / 21 LTS).
 */
public final class PaymentDomain {

    private PaymentDomain() {}

    /**
     * Algebraic Data Type (ADT) Root.
     * Permits only specified records to form an exhaustive, closed type hierarchy.
     */
    public sealed interface PaymentMethod permits CreditCard, BankTransfer, CryptoCurrency {}

    public record CreditCard(String cardNumber, String cvv, String expiry) implements PaymentMethod {
        // Compact Constructor with invariant validations
        public CreditCard {
            Objects.requireNonNull(cardNumber, "Card number cannot be null");
            if (cardNumber.replaceAll("\\s+", "").length() < 13) {
                throw new IllegalArgumentException("Invalid card length");
            }
        }
    }

    public record BankTransfer(String iban, String bic) implements PaymentMethod {
        public BankTransfer {
            Objects.requireNonNull(iban, "IBAN cannot be null");
            Objects.requireNonNull(bic, "BIC cannot be null");
        }
    }

    public record CryptoCurrency(String walletAddress, String network) implements PaymentMethod {
        public CryptoCurrency {
            Objects.requireNonNull(walletAddress, "Wallet address cannot be null");
        }
    }

    /**
     * Modern Pattern Matching Switch Expression.
     * Notice: No 'default' branch needed because the sealed hierarchy is fully exhaustive.
     */
    public static BigDecimal calculateTransactionFee(PaymentMethod payment, BigDecimal amount) {
        return switch (payment) {
            case CreditCard card -> amount.multiply(new BigDecimal("0.025")); // 2.5% fee
            case BankTransfer bank -> new BigDecimal("1.50");                  // Flat $1.50 wire fee
            case CryptoCurrency crypto -> amount.multiply(new BigDecimal("0.010")); // 1.0% network fee
        };
    }
}

