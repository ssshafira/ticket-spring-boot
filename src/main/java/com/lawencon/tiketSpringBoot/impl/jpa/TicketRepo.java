package com.lawencon.tiketSpringBoot.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
	
	@Query("select t.harga from Type t where typeId =?1")
	public int getHargaByTipe(Long tipeId);
	
	@Query("select sum(t.harga) from Ticket t where transaction.transId =?1")
	public int getTotalHarga(Long transId);
		
}
