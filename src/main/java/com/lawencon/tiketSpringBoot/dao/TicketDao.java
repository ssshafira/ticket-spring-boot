package com.lawencon.tiketSpringBoot.dao;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Ticket;

public interface TicketDao {

	abstract List<Ticket> findAll();
	abstract void insert(Ticket tiket);
	abstract void delete(Ticket tiket) throws Exception;
	
	abstract void cekDiskon(String diskon, Ticket tiket);
	abstract int getHargaByTipe(Ticket tiket);
	abstract Ticket findById(Long id) throws Exception;
}
