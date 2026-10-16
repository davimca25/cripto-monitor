package io.github.davimca25.domain.quote;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public record Quote(String coinId, BigDecimal priceUsd, Instant observedAt) {
    public Quote {
        Objects.requireNonNull(coinId, "coinId cannot be null");
        Objects.requireNonNull(priceUsd, "priceUsd cannot be null");
        Objects.requireNonNull(observedAt, "observedAt cannot be null");

        if (coinId.isBlank()) {
            throw new IllegalArgumentException("coinId must not be blank");
        }

        if (priceUsd.signum() <= 0) {
            throw new IllegalArgumentException("priceUsd must be greater than zero");
        }
    }
}
