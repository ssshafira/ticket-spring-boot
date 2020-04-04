package com.lawencon.tiketSpringBoot.service;

import com.lawencon.tiketSpringBoot.model.Ticket;

public interface TicketService {

	abstract void insert(Ticket tiket, String auth, String auth2);
}
