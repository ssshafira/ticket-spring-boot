package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.tiketSpringBoot.dao.CustomerDao;
import com.lawencon.tiketSpringBoot.dao.TypeDao;
import com.lawencon.tiketSpringBoot.model.Type;

@Service
@Transactional
public class TypeImpl implements TypeService {
	
	@Autowired
	@Qualifier("type_repo_hibernate") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private TypeDao typeDao;
	
	@Autowired
	@Qualifier("cust_repo_hibernate") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private CustomerDao custDao;

	@Override
	public List<Type> findAll(String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			return typeDao.findAll();
		else
			return null;
	}

	@Override
	public ResponseEntity<?> insert(Type tipe, String au0, String au1) throws Exception {
		try {
			if (custDao.cekValid(au0, au1) == 1) {
				typeDao.insert(tipe);
				return new ResponseEntity<>(findAll(au0, au1), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Authorization tidak valid", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Insert", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public void update(Type tipe, String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			typeDao.update(tipe);
	}

	@Override
	public void delete(Type tipe, String au0, String au1) throws Exception {
		if (custDao.cekValid(au0, au1) == 1)
			typeDao.delete(tipe);
	}

	
}
