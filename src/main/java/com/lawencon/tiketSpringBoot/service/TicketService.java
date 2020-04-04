package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lawencon.tiketSpringBoot.model.Ticket;

public interface TicketService {

	abstract void insert(Ticket tiket, String auth, String auth2);
	abstract ResponseEntity<?> cetakStruk(Ticket tiket);
	abstract List<Ticket> findAll(String string, String string2);
	abstract void delete(Ticket tiket, String string, String string2) throws Exception;
}
