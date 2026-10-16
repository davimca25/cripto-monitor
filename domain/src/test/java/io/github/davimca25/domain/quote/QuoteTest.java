package io.github.davimca25.domain.quote;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuoteTest {

    private static final BigDecimal VALID_PRICE_USD = new BigDecimal("454.544");
    private static final Instant VALID_OBSERVED_AT = Instant.parse("2026-10-16T12:00:00Z");

    @Test
    void shouldCreateQuoteWithValidValues() {

        // arrange
        String coinId = "bitcoin";

        // act
        Quote quote = new Quote(coinId, VALID_PRICE_USD, VALID_OBSERVED_AT);

        // assert
        assertThat(quote.coinId()).isEqualTo("bitcoin");
        assertThat(quote.priceUsd()).isEqualTo(VALID_PRICE_USD);
        assertThat(quote.observedAt()).isEqualTo(VALID_OBSERVED_AT);
    }

    @Test
    void shouldRejectBlankCoinId() {
        assertThatThrownBy(() -> new Quote("    ", VALID_PRICE_USD, VALID_OBSERVED_AT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("coinId must not be blank");
    }

    @Test
    void shouldRejectZeroPrice() {
        BigDecimal price = new BigDecimal("0");
        assertThatThrownBy(() -> new Quote("bitcoin", price, VALID_OBSERVED_AT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("priceUsd must be greater than zero");
    }

    @Test
    void shouldRejectNullCoinId() {
        assertThatThrownBy(() -> new Quote(null, VALID_PRICE_USD, VALID_OBSERVED_AT))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("coinId cannot be null");
    }

    @Test
    void shouldRejectNullPriceUsd() {
        assertThatThrownBy(() -> new Quote("bitcoin", null, VALID_OBSERVED_AT))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("priceUsd cannot be null");
    }

    @Test
    void shouldRejectNullObservedAt() {
        assertThatThrownBy(() -> new Quote("bitcoin", VALID_PRICE_USD, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("observedAt cannot be null");
    }
}