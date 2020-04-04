package com.lawencon.tiketSpringBoot.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	@Query("Select count(c) from Customer c where c.uname =?1 and pwd =?2")
	public Long cekValid(String uname, String pwd);
	
	@Query("Select c from Customer c where uname =?1")
	public List<Customer> findByUsername(String uname);
	
	
}
