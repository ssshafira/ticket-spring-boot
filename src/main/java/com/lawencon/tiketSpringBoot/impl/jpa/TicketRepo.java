package com.lawencon.tiketSpringBoot.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

	
	public void cekDiskon(String diskon, Ticket tiket);
	
	@Query("select t.harga from Type t where typeId =?1")
	public int getHargaByTipe(Long tipeId);
		
	public String cetakStruk(Ticket tiket);
}
