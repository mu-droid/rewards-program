package com.example.rewards.service;

import com.example.rewards.dto.RewardResponseDto;
import com.example.rewards.entity.Customer;
import com.example.rewards.entity.Transaction;
import com.example.rewards.exception.ResourceNotFoundException;
import com.example.rewards.repository.CustomerRepository;
import com.example.rewards.repository.TransactionRepository;
import com.example.rewards.util.RewardUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service responsible for reward calculations.
 */
@Service
@RequiredArgsConstructor
public class RewardService {

    private final CustomerRepository customerRepository;

    private final TransactionRepository transactionRepository;

    /**
     * Fetches reward summary for a customer.
     *
     * @param customerId customer id
     * @return reward summary response
     */
    public RewardResponseDto getRewards(Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer not found with id: " + customerId));

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(3).withDayOfMonth(1);

        List<Transaction> transactions =
                transactionRepository.findByCustomerIdAndTransactionDateBetween(
                        customerId, startDate, endDate);

        Map<String, Integer> monthlyRewards = transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> YearMonth.from(t.getTransactionDate()).toString(),
                        Collectors.summingInt(
                                t -> RewardUtil.calculatePoints(t.getAmount())
                        )
                ));



        int totalRewards = monthlyRewards.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        return RewardResponseDto.builder()
                .customerId(customer.getId())
                .customerName(customer.getName())
                .monthlyRewards(monthlyRewards)
                .totalRewards(totalRewards)
                .build();
    }
    /**
     * Fetches reward summaries for all customers.
     *
     * @return list of reward summaries
     */
    public List<RewardResponseDto> getAllRewards() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> getRewards(customer.getId()))
                .toList();
    }
}
