package io.github.davimca25.domain.alert;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AlertTest {

    private static final UUID VALID_ALERT_ID = UUID.randomUUID();
    private static final BigDecimal VALID_THRESHOLD = new BigDecimal("430.500");
    private static final Instant VALID_TRIGGERED_AT = Instant.parse("2026-10-16T12:00:00Z");

    @Test
    void shouldCreateAlertWithValidValues() {

        Alert alert = new Alert("davi", VALID_ALERT_ID, "bitcoin", AlertType.PRICE_BELOW, VALID_THRESHOLD, true, VALID_TRIGGERED_AT);

        assertThat(alert.userId()).isEqualTo("davi");
        assertThat(alert.coinId()).isEqualTo("bitcoin");
    }

    @Test
    void shouldRejectBlankUserId() {
        assertThatThrownBy(() -> new Alert(
                "    ",
                VALID_ALERT_ID,
                "bitcoin",
                AlertType.PRICE_ABOVE,
                VALID_THRESHOLD,
                true,
                VALID_TRIGGERED_AT
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("userId must not be blank");
    }
}