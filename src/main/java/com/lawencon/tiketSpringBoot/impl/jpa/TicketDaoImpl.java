package com.lawencon.tiketSpringBoot.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TicketDao;
import com.lawencon.tiketSpringBoot.model.Ticket;

@Repository("ticket_repo_jpa")
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private DiscountRepo discountRepo;

	@Override
	public void insert(Ticket tiket) {
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
			int pot = discountRepo.findPotongan(tiket.getDiskon());
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

	@Override
	public List<Ticket> findAll() {
		return ticketRepo.findAll();
	}

	@Override
	public void delete(Ticket tiket) throws Exception {
		Ticket cek = new Ticket();
		cek = findById(tiket.getTicketId());
		ticketRepo.delete(cek);
	}

	@Override
	public Ticket findById(Long id) throws Exception {
		return ticketRepo.findById(id).orElse(null);
	}
	
	
}
