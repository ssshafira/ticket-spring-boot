package com.lawencon.tiketSpringBoot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.tiketSpringBoot.dao.TicketDao;
import com.lawencon.tiketSpringBoot.impl.hibernate.CustomRepo;
import com.lawencon.tiketSpringBoot.model.Ticket;

@Service
@Transactional
public class TicketImpl extends CustomRepo implements TicketService {

	@Autowired
	@Qualifier("ticket_repo_hibernate") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private TicketDao ticketDao;
	
	@Override
	public void insert(Ticket tiket) {
		ticketDao.insert(tiket);
	}

}
