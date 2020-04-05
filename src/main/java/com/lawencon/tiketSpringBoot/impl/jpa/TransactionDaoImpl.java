package com.lawencon.tiketSpringBoot.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TransactionDao;
import com.lawencon.tiketSpringBoot.model.Ticket;
import com.lawencon.tiketSpringBoot.model.TransTiket;
import com.lawencon.tiketSpringBoot.model.Transaction;

@Repository("trx_repo_jpa")
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private TransactionRepo trxRepo;
	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private DiscountRepo discountRepo;

	@Override
	public List<Transaction> findAll() {
		return trxRepo.findAll();
	}

	@Override
	public Transaction findById(Long id) throws Exception {
		return trxRepo.findById(id).orElse(null);
	}

	@Override
	public void insert(Transaction transaction) {
		Transaction cek = new Transaction();
		cek.setTransId(transaction.getTransId());
		cek.setCustomer(transaction.getCustomer());
		trxRepo.save(cek);
	}

	@Override
	public void delete(Transaction transaction) throws Exception {
		Transaction cek = new Transaction();
		cek = findById(transaction.getTransId());
		trxRepo.delete(cek);
	}

	@Override
	public void saveAll(TransTiket trx) throws Exception {
		trxRepo.save(trx.getTransaction());		
		List<Ticket> lt = trx.getListTicket();		
		lt.forEach(val -> {		
			insertToTicket(val);
		});	
		Transaction cek = new Transaction();
		cek = findById(trx.getTransaction().getTransId());
		cek.setTotal(ticketRepo.getTotalHarga(trx.getTransaction().getTransId()));
		trxRepo.save(cek);
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
		ticketRepo.save(cek);
	}
	
	@Override
	public void cekDiskon(String diskon, Ticket tiket) {
		try {
			discountRepo.findKode(diskon);
			int pot = discountRepo.findPotongan(tiket.getDiskon()).getPotongan();
			tiket.setHarga(getHargaByTipe(tiket) - pot);		
		} catch (Exception e) {
			tiket.setDiskon("-");
			tiket.setHarga(getHargaByTipe(tiket));
		}
	}

	@Override
	public int getHargaByTipe(Ticket tiket) {
		return ticketRepo.getHargaByTipe(tiket.getTipe().getTypeId());
	}

	
}
