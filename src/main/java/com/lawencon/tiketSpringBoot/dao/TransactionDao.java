package com.lawencon.tiketSpringBoot.dao;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Transaction;

public interface TransactionDao {

	abstract List<Transaction> findAll();
	abstract Transaction findById(Long id) throws Exception;
	abstract void insert(Transaction transaction);
	abstract void delete(Transaction transaction) throws Exception;
}
