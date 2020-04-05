package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.tiketSpringBoot.dao.CustomerDao;
import com.lawencon.tiketSpringBoot.dao.TransactionDao;
import com.lawencon.tiketSpringBoot.model.TransTiket;
import com.lawencon.tiketSpringBoot.model.Transaction;

@Service
@Transactional
public class TransactionImpl implements TransactionService {
	
	@Autowired
	@Qualifier("trx_repo_jpa") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private TransactionDao trxDao;

	@Autowired
	@Qualifier("cust_repo_hibernate") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private CustomerDao custDao;

	@Override
	public void insert(Transaction trx, String auth, String auth2) {
		if (custDao.cekValid(auth, auth2) == 1)
			trxDao.insert(trx);
	}

	@Override
	public List<Transaction> findAll(String auth, String auth2) {
		if (custDao.cekValid(auth, auth2) == 1)
			return trxDao.findAll();
		else return null;
	}

	@Override
	public void delete(Transaction trx, String auth, String auth2) throws Exception {
		if (custDao.cekValid(auth, auth2) == 1)
			trxDao.delete(trx);
	}

	@Override
	public void saveAll(TransTiket trx, String auth, String auth2) throws Exception {
		if (custDao.cekValid(auth, auth2) == 1)
			trxDao.saveAll(trx);
	}

	
}
