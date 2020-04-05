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
