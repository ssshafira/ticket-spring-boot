package com.lawencon.tiketSpringBoot.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
