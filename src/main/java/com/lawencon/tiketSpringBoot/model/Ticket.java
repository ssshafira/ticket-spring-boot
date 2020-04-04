package com.lawencon.tiketSpringBoot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ticket {
	
	/**** DETAIL ****/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	@ManyToOne
	@JoinColumn(name = "transId")
	private Transaction transaction;
	
	@OneToOne
	@JoinColumn(name = "typeId")
	private Type tipe;
	
	private String kursi;
	private int harga;
	private Date berangkat;
	private String asal;
	private String tujuan;
	private String diskon;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Type getTipe() {
		return tipe;
	}

	public void setTipe(Type tipe) {
		this.tipe = tipe;
	}

	public String getKursi() {
		return kursi;
	}

	public void setKursi(String kursi) {
		this.kursi = kursi;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public Date getBerangkat() {
		return berangkat;
	}

	public void setBerangkat(Date berangkat) {
		this.berangkat = berangkat;
	}

	public String getAsal() {
		return asal;
	}

	public void setAsal(String asal) {
		this.asal = asal;
	}

	public String getTujuan() {
		return tujuan;
	}

	public void setTujuan(String tujuan) {
		this.tujuan = tujuan;
	}

	public String getDiskon() {
		return diskon;
	}

	public void setDiskon(String diskon) {
		this.diskon = diskon;
	}
	
}
