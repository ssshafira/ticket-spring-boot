package com.lawencon.tiketSpringBoot.dao;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Ticket;
import com.lawencon.tiketSpringBoot.model.TransTiket;
import com.lawencon.tiketSpringBoot.model.Transaction;

public interface TransactionDao {

	abstract List<Transaction> findAll();
	abstract Transaction findById(Long id) throws Exception;
	abstract void insert(Transaction transaction);
	abstract void delete(Transaction transaction) throws Exception;
	abstract void saveAll(TransTiket trx) throws Exception;
	
	abstract void insertToTicket(Ticket tiket);
	abstract void cekDiskon(String diskon, Ticket tiket);
	abstract int getHargaByTipe(Ticket tiket);
}
