package io.github.davimca25.domain.alert;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Alert(
        String userId,
        UUID alertId,
        String coinId,
        AlertType type,
        BigDecimal threshold,
        boolean active,
        Instant triggeredAt
) {
    public Alert {
        Objects.requireNonNull(userId, "userId cannot be null");
        Objects.requireNonNull(alertId, "alertId cannot be null");
        Objects.requireNonNull(coinId, "coinId cannot be null");
        Objects.requireNonNull(type, "type cannot be null");
        Objects.requireNonNull(threshold, "threshold cannot be null");

        if (userId.isBlank()) {
            throw new IllegalArgumentException("userId must not be blank");
        }

        if (coinId.isBlank()) {
            throw new IllegalArgumentException("coinId must not be blank");
        }

        if (threshold.signum() <= 0) {
            throw new IllegalArgumentException("threshold must be greater than zero");
        }
    }
}
