package com.example.rewards.controller;

import com.example.rewards.dto.RewardResponseDto;
import com.example.rewards.service.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * REST controller exposing reward APIs.
 */
@RestController
@RequestMapping("/api/rewards")
@RequiredArgsConstructor
@Tag(name = "Rewards", description = "Endpoints for calculating customer reward points")
public class RewardController {

    private final RewardService rewardService;
    /**
     * Returns reward details for a customer.
     *
     * @param customerId customer id
     * @return reward response
     */
    @GetMapping("/{customerId}")
    @Operation(
            summary = "Get rewards for a specific customer",
            description = "Returns monthly and total reward points for the last 3 months"
    )
    public RewardResponseDto getRewards(
            @Parameter(description = "ID of the customer", required = true)
            @PathVariable Long customerId
    ) {
        return rewardService.getRewards(customerId);
    }
    /**
     * Returns reward summaries for all customers.
     *
     * @return list of reward responses
     */
    @GetMapping("/all")
    @Operation(
            summary = "Get rewards for all customers",
            description = "Returns monthly and total reward points for every customer over the last 3 months"
    )
    public List<RewardResponseDto> getAllRewards() {
        return rewardService.getAllRewards();
    }
}
