package com.lawencon.tiketSpringBoot.dao;

import com.lawencon.tiketSpringBoot.model.Ticket;

public interface TicketDao {

	abstract void insert(Ticket tiket);
	abstract void cekDiskon(String diskon, Ticket tiket);
	abstract int getHargaByTipe(Ticket tiket);
}
