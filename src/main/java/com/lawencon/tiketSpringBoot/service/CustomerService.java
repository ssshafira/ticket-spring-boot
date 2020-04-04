package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Customer;

public interface CustomerService {

	abstract Long cekValid(String uname, String pwd);

	abstract List<Customer> findAll(String au0, String au1) throws Exception;
	
	abstract List<Customer> findByUsername(String uname);

	abstract Customer findById(Long id);

	abstract void insert(Customer cus) throws Exception;

	abstract void update(Customer cus, String au0, String au1) throws Exception;

	abstract void delete(Customer cus, String au0, String au1) throws Exception;
}
