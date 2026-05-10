package com.example.rewards.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class RewardResponseDto {

    private Long customerId;

    private String customerName;

    private Map<String, Integer> monthlyRewards;

    private Integer totalRewards;
}
