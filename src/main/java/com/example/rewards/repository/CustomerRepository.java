package com.example.rewards.repository;

import com.example.rewards.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository for customer persistence operations.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
