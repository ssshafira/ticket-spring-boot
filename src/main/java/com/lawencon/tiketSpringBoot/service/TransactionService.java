package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.TransTiket;
import com.lawencon.tiketSpringBoot.model.Transaction;

public interface TransactionService {

	abstract void insert(Transaction trx, String auth, String auth2);
	abstract List<Transaction> findAll(String string, String string2);
	abstract void delete(Transaction trx, String string, String string2) throws Exception;
	abstract void saveAll(TransTiket trx, String auth1, String auth2) throws Exception;
}
