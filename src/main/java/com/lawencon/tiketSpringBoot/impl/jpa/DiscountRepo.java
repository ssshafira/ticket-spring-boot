package com.lawencon.tiketSpringBoot.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.model.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {

	@Query("Select d from Discount d where d.kode =?1")
	public Discount findKode(String kode);
	
	@Query("Select d from Discount d where d.kode =?1")
	public Discount findPotongan(String kode);
}
