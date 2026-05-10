package com.example.rewards.util;

import java.math.BigDecimal;

public class RewardUtil {

    private RewardUtil() {
        // utility class
    }

    /**
     * Calculates reward points for a given transaction amount.
     *
     * Rules:
     * - 0 points for amounts $50 and below
     * - 1 point per dollar spent between $50 and $100
     * - 2 points per dollar spent above $100
     *
     * Example: $120 purchase = 2x$20 + 1x$50 = 90 points
     */
    public static int calculatePoints(BigDecimal amount) {

        int purchase = amount.intValue();

        if (purchase <= 50) {
            return 0;
        }

        if (purchase <= 100) {
            return purchase - 50;
        }

        return 50 + ((purchase - 100) * 2);
    }
}
