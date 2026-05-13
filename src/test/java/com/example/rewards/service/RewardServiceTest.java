package com.example.rewards.service;

import com.example.rewards.dto.RewardResponseDto;
import com.example.rewards.entity.Customer;
import com.example.rewards.entity.Transaction;
import com.example.rewards.repository.CustomerRepository;
import com.example.rewards.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RewardServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private RewardService rewardService;

    @Test
    void shouldReturnRewardSummary() {

        Customer customer = Customer.builder()
                .id(1L)
                .name("Mehul")
                .build();

        Transaction transaction = Transaction.builder()
                .id(1L)
                .customerId(1L)
                .amount(BigDecimal.valueOf(120))
                .transactionDate(LocalDate.now())
                .build();

        when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));

        when(transactionRepository
                .findByCustomerIdAndTransactionDateBetween(
                        org.mockito.ArgumentMatchers.eq(1L),
                        org.mockito.ArgumentMatchers.any(),
                        org.mockito.ArgumentMatchers.any()))
                .thenReturn(List.of(transaction));

        RewardResponseDto response =
                rewardService.getRewards(1L);

        assertEquals(90, response.getTotalRewards());
    }
}