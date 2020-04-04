package com.lawencon.tiketSpringBoot.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.model.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {

	@Query("Select d.kode from Discount d where kode =?1")
	public List<Discount> findKode(String kode);
	
	@Query("Select d.potongan from Discount d where kode =?1")
	public int findPotongan(String kode);
}
