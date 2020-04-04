package com.lawencon.tiketSpringBoot.impl.hibernate;

import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TicketDao;
import com.lawencon.tiketSpringBoot.model.Ticket;

@Repository("ticket_repo_hibernate")
public class TicketDaoImpl extends CustomRepo implements TicketDao {

	@Override
	public void insert(Ticket tiket) {
		Ticket cek = new Ticket();
		cek.setAsal(tiket.getAsal());
		cek.setBerangkat(tiket.getBerangkat());
		cek.setKursi(tiket.getKursi());
		cek.setTipe(tiket.getTipe());
		cek.setTujuan(tiket.getTujuan());
		em.persist(cek);
	}
	
	
}
