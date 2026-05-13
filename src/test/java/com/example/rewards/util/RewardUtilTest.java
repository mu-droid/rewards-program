package com.example.rewards.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RewardUtilTest {

    @Test
    void shouldReturnZeroPointsForAmountLessThan50() {

        int points =
                RewardUtil.calculatePoints(BigDecimal.valueOf(40));

        assertEquals(0, points);
    }

    @Test
    void shouldReturnZeroPointsForAmountEqualTo50() {

        int points =
                RewardUtil.calculatePoints(BigDecimal.valueOf(50));

        assertEquals(0, points);
    }

    @Test
    void shouldCalculatePointsBetween50And100() {

        int points =
                RewardUtil.calculatePoints(BigDecimal.valueOf(75));

        assertEquals(25, points);
    }

    @Test
    void shouldCalculatePointsAbove100() {

        int points =
                RewardUtil.calculatePoints(BigDecimal.valueOf(120));

        assertEquals(90, points);
    }
}