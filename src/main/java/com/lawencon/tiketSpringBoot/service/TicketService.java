package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Ticket;

public interface TicketService {

	abstract List<Ticket> findAll(String string, String string2);
	abstract void delete(Ticket tiket, String string, String string2) throws Exception;
}
