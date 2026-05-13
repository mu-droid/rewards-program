package com.example.rewards.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
/**
 * DTO representing customer reward summary.
 */
@Data
@Builder
public class RewardResponseDto {

    private Long customerId;

    private String customerName;

    private Map<String, Integer> monthlyRewards;

    private Integer totalRewards;
}
