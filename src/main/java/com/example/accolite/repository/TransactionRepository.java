package com.example.accolite.repository;

import com.example.accolite.entity.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<List<Transaction>> findByStatus(TransactionCategory transactionStatus);
}