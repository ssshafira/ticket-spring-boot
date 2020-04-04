package com.lawencon.tiketSpringBoot.impl.hibernate;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TransactionDao;
import com.lawencon.tiketSpringBoot.model.Transaction;

@Repository("trans_repo_hibernate")
public class TransactionDaoImpl extends CustomRepo implements TransactionDao {

	@Override
	public void insert(Transaction transaction) {
		Transaction cek = new Transaction();
		cek.setCustomer(transaction.getCustomer());
		em.persist(cek);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findAll() {
		Query q = em.createQuery("from Transaction");
		return q.getResultList();
	}

	@Override
	public void delete(Transaction transaction) throws Exception {
		Transaction cek = new Transaction();
		cek = findById(transaction.getTransId());
		em.remove(cek);
	}

	@Override
	public Transaction findById(Long id) throws Exception {
		Query q = em.createQuery(" from Transaction where transId =:idParam");
		q.setParameter("idParam", id);
		return (Transaction) q.getSingleResult();
	}

	
}
