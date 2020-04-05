package com.lawencon.tiketSpringBoot.model;

import java.util.List;

public class TransTiket {

	private Transaction transaction;
	private List<Ticket> listTicket;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<Ticket> getListTicket() {
		return listTicket;
	}

	public void setListTicket(List<Ticket> listTicket) {
		this.listTicket = listTicket;
	}

	

}
