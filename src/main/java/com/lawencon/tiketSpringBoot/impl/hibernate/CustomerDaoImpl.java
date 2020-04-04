package com.lawencon.tiketSpringBoot.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.CustomerDao;
import com.lawencon.tiketSpringBoot.model.Customer;
import com.lawencon.tiketSpringBoot.service.CustomerService;

@Repository("cust_repo_hibernate")
public class CustomerDaoImpl extends CustomRepo implements CustomerDao {

	@Autowired
	private CustomerService custService;

	@Override
	public Long cekValid(String uname, String pwd) {
		Query q = em.createQuery("select count(*) from Customer where uname =: uParam and pwd =: pParam");
		q.setParameter("uParam", uname);
		q.setParameter("pParam", pwd);
		return (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() throws Exception {
		Query q = em.createQuery(" from Customer");
		return q.getResultList();
	}

	@Override
	public Customer findById(Long id) {
		Query q = em.createQuery(" from Customer where custId =:idParam");
		q.setParameter("idParam", id);
		return (Customer) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByUsername(String uname) {
		Query q = em.createQuery(" from Customer where uname =:uParam");
		q.setParameter("uParam", uname);
		return q.getResultList();
	}

	@Override
	public void insert(Customer cus) throws Exception {
		List<Customer> listData = new ArrayList<>();
		listData = custService.findByUsername(cus.getUname());
		if (listData.isEmpty()) {
			Customer cek = new Customer();
			cek.setUname(cus.getUname());
			cek.setPwd(cus.getPwd());
			cek.setNama(cus.getNama());
			em.persist(cek);
		}
	}

	@Override
	public void update(Customer cus) throws Exception {
		List<Customer> listData = new ArrayList<>();
		listData = custService.findByUsername(cus.getUname());
		if (listData.isEmpty()) {
			Customer cek = new Customer();
			cek = findById(cus.getCustId());
			cek.setUname(cus.getUname());
			cek.setPwd(cus.getPwd());
			cek.setNama(cus.getNama());
			em.merge(cek);
		}
	}

	@Override
	public void delete(Customer cus) throws Exception {
		Customer cek = new Customer();
		cek = findById(cus.getCustId());
		em.remove(cek);
	}

}
