package dev.anurag.javahandbook.modern.recordsandsealed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentDomainTest {

    @Test
    @DisplayName("Compact constructor should enforce record field invariants")
    void recordInvariantsEnforced() {
        assertThatThrownBy(() -> new PaymentDomain.CreditCard("123", "999", "12/28"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Pattern matching switch computes correct fee for each payment type exhaustively")
    void patternMatchingSwitchCalculatesFees() {
        BigDecimal amount = new BigDecimal("100.00");

        PaymentDomain.PaymentMethod card = new PaymentDomain.CreditCard("4111 2222 3333 4444", "123", "11/27");
        PaymentDomain.PaymentMethod wire = new PaymentDomain.BankTransfer("DE89370400440532013000", "DBEUMM21");
        PaymentDomain.PaymentMethod crypto = new PaymentDomain.CryptoCurrency("0x71C...438", "Ethereum");

        assertThat(PaymentDomain.calculateTransactionFee(card, amount)).isEqualByComparingTo(new BigDecimal("2.500"));
        assertThat(PaymentDomain.calculateTransactionFee(wire, amount)).isEqualByComparingTo(new BigDecimal("1.50"));
        assertThat(PaymentDomain.calculateTransactionFee(crypto, amount)).isEqualByComparingTo(new BigDecimal("1.000"));
    }
}

