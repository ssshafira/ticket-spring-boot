package com.lawencon.tiketSpringBoot.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.CustomerDao;
import com.lawencon.tiketSpringBoot.model.Customer;

@Repository("customer_repo_jpa")
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Long cekValid(String uname, String pwd) {
		return customerRepo.cekValid(uname, pwd);
	}

	@Override
	public List<Customer> findAll() throws Exception {
		return customerRepo.findAll();
	}

	@Override
	public List<Customer> findByUsername(String uname) {
		return customerRepo.findByUsername(uname);
	}

	@Override
	public Customer findById(Long id) {
		return customerRepo.findById(id).orElse(null);
	}

	@Override
	public void insert(Customer cus) throws Exception {
		List<Customer> cekUsername =  findByUsername(cus.getUname());
		if (cekUsername.isEmpty()) {
			Customer cek = new Customer();
			cek.setNama(cus.getNama());
			cek.setUname(cus.getUname());
			cek.setPwd(cus.getPwd());
			customerRepo.save(cek);
		} else {
			System.out.println("username sudah ada");
		}
	}

	@Override
	public void update(Customer cus) throws Exception {
		List<Customer> cekUsername =  findByUsername(cus.getUname());
		if (cekUsername.isEmpty()) {
			Customer cek = new Customer();
			cek = findById(cus.getCustId());
			cek.setNama(cus.getNama());
			cek.setUname(cus.getUname());
			cek.setPwd(cus.getPwd());
			customerRepo.save(cek);
		} else {
			System.out.println("username sudah ada");
		}
	}

	@Override
	public void delete(Customer cus) throws Exception {
		Customer cek = new Customer();
		cek = findById(cus.getCustId());
		customerRepo.delete(cek);
	}

	
}
