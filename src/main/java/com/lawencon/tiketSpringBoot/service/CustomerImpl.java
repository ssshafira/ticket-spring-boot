package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.tiketSpringBoot.dao.CustomerDao;
import com.lawencon.tiketSpringBoot.model.Customer;

@Service
@Transactional
public class CustomerImpl implements CustomerService {

	@Autowired
	@Qualifier("cust_repo_hibernate") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private CustomerDao custDao;

	@Override
	public Long cekValid(String uname, String pwd) {
		return custDao.cekValid(uname, pwd);
	}

	@Override
	public List<Customer> findAll(String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			return custDao.findAll();
		else
			return null;
	}

	@Override
	public List<Customer> findByUsername(String uname) {
		return custDao.findByUsername(uname);
	}

	@Override
	public Customer findById(Long id) {
		return custDao.findById(id);
	}

	@Override
	public void insert(Customer cus) throws Exception {
		custDao.insert(cus);
	}

	@Override
	public void update(Customer cus, String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			custDao.update(cus);
	}

	@Override
	public void delete(Customer cus, String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			custDao.delete(cus);
	}

}
