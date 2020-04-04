package com.lawencon.tiketSpringBoot.dao;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Customer;

public interface CustomerDao {

	abstract Long cekValid(String uname, String pwd);

	abstract List<Customer> findAll() throws Exception;
	
	abstract List<Customer> findByUsername(String uname);

	abstract Customer findById(Long id);

	abstract void insert(Customer cus) throws Exception;

	abstract void update(Customer cus) throws Exception;

	abstract void delete(Customer cus) throws Exception;
}
