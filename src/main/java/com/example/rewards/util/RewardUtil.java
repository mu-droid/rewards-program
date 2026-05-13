package com.example.rewards.util;

import java.math.BigDecimal;
/**
 * Utility class for reward point calculations.
 */
public class RewardUtil {

    private RewardUtil() {
        // utility class
    }


    /**
     * Calculates reward points based on transaction amount.
     *
     * Rules:
     * - No points for first $50
     * - 1 point for every dollar between $51-$100
     * - 2 points for every dollar above $100
     *
     * @param amount transaction amount
     * @return reward points
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
