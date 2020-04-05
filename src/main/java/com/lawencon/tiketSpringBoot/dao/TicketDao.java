package com.lawencon.tiketSpringBoot.dao;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Ticket;

public interface TicketDao {

	abstract List<Ticket> findAll();
	
	abstract void delete(Ticket tiket) throws Exception;
	
	abstract Ticket findById(Long id) throws Exception;
}
