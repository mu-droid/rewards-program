package com.example.rewards.config;

import com.example.rewards.entity.Customer;
import com.example.rewards.entity.Transaction;
import com.example.rewards.repository.CustomerRepository;
import com.example.rewards.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {

            // Customers
            Customer mehul = customerRepository.save(
                    Customer.builder().name("Mehul").build());

            Customer saransh = customerRepository.save(
                    Customer.builder().name("Saransh").build());

            Customer suyash = customerRepository.save(
                    Customer.builder().name("Suyash").build());


            transactionRepository.saveAll(List.of(

                    Transaction.builder()
                            .customerId(mehul.getId())
                            .amount(BigDecimal.valueOf(120))
                            .transactionDate(LocalDate.now().minusMonths(1))
                            .build(),

                    Transaction.builder()
                            .customerId(mehul.getId())
                            .amount(BigDecimal.valueOf(75))
                            .transactionDate(LocalDate.now().minusMonths(2))
                            .build(),

                    Transaction.builder()
                            .customerId(mehul.getId())
                            .amount(BigDecimal.valueOf(45))
                            .transactionDate(LocalDate.now().minusMonths(3).plusDays(5))
                            .build(),

                    Transaction.builder()
                            .customerId(saransh.getId())
                            .amount(BigDecimal.valueOf(200))
                            .transactionDate(LocalDate.now().minusMonths(1))
                            .build(),

                    Transaction.builder()
                            .customerId(saransh.getId())
                            .amount(BigDecimal.valueOf(90))
                            .transactionDate(LocalDate.now().minusMonths(2))
                            .build(),

                    Transaction.builder()
                            .customerId(saransh.getId())
                            .amount(BigDecimal.valueOf(130))
                            .transactionDate(LocalDate.now().minusMonths(3).plusDays(10))
                            .build(),

                    Transaction.builder()
                            .customerId(suyash.getId())
                            .amount(BigDecimal.valueOf(50))
                            .transactionDate(LocalDate.now().minusMonths(1))
                            .build(),

                    Transaction.builder()
                            .customerId(suyash.getId())
                            .amount(BigDecimal.valueOf(110))
                            .transactionDate(LocalDate.now().minusMonths(1))
                            .build(),

                    Transaction.builder()
                            .customerId(suyash.getId())
                            .amount(BigDecimal.valueOf(60))
                            .transactionDate(LocalDate.now().minusMonths(2))
                            .build()
            ));
        };
    }
}
