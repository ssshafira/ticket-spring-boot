package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.tiketSpringBoot.dao.CustomerDao;
import com.lawencon.tiketSpringBoot.dao.DiscountDao;
import com.lawencon.tiketSpringBoot.model.Discount;

@Service
@Transactional
public class DiscountImpl implements DiscountService {

	@Autowired
	@Qualifier("discount_repo_hibernate") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private DiscountDao discountDao;
	
	@Autowired
	@Qualifier("cust_repo_hibernate") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private CustomerDao custDao;

	@Override
	public List<Discount> findAll(String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			return discountDao.findAll();
		else
			return null;
	}

	@Override
	public ResponseEntity<?> insert(Discount diskon, String au0, String au1) throws Exception {
		try {
			if (custDao.cekValid(au0, au1) == 1) {
				discountDao.insert(diskon);
				return new ResponseEntity<>(findAll(au0, au1), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Authorization tidak valid", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Insert", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public void update(Discount diskon, String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			discountDao.update(diskon);
	}

	@Override
	public void delete(Discount diskon, String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			discountDao.delete(diskon);
	}

	
}
