package com.lawencon.tiketSpringBoot.impl.hibernate;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TransactionDao;
import com.lawencon.tiketSpringBoot.model.Ticket;
import com.lawencon.tiketSpringBoot.model.TransTiket;
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

	@Override
	public void saveAll(TransTiket trx) throws Exception {
		insert(trx.getTransaction());
		List<Ticket> lt = trx.getListTicket();	
		lt.forEach(val -> {
			insertToTicket(val);
		});	
	}

	@Override
	public void insertToTicket(Ticket tiket) {
		Ticket cek = new Ticket();
		cek.setTransaction(tiket.getTransaction());
		cek.setAsal(tiket.getAsal());
		cek.setBerangkat(tiket.getBerangkat());
		cek.setKursi(tiket.getKursi());
		cek.setTipe(tiket.getTipe());
		cek.setTujuan(tiket.getTujuan());
		cek.setDiskon(tiket.getDiskon());
		cekDiskon(tiket.getDiskon(), cek);
		em.persist(cek);
	}

	@Override
	public void cekDiskon(String diskon, Ticket tiket) {
		try {
			Query q = em.createQuery("select kode from Discount where kode =:kodeParam");
			q.setParameter("kodeParam", diskon);
			int pot;
			Query d = em.createQuery("select potongan from Discount where kode =:kodeParam");
			d.setParameter("kodeParam", tiket.getDiskon());
			pot = (int) d.getSingleResult();
			tiket.setHarga(getHargaByTipe(tiket) - pot);
		} catch (Exception e) {
			tiket.setDiskon("-");
			tiket.setHarga(getHargaByTipe(tiket));
		}
	}

	@Override
	public int getHargaByTipe(Ticket tiket) {
		Query q = em.createQuery("select harga from Type where typeId =:idParam");
		q.setParameter("idParam", tiket.getTipe().getTypeId());
		return (int) q.getSingleResult();
	}

	
}
