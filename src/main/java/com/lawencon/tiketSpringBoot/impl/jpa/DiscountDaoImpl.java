package com.lawencon.tiketSpringBoot.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.DiscountDao;
import com.lawencon.tiketSpringBoot.model.Discount;

@Repository("discount_repo_jpa")
public class DiscountDaoImpl implements DiscountDao {
	
	@Autowired
	private DiscountRepo discountRepo;

	@Override
	public List<Discount> findAll() throws Exception {
		return discountRepo.findAll();
	}

	@Override
	public void insert(Discount diskon) throws Exception {
		List<Discount> cekKode = findKode(diskon.getKode());
		if (cekKode.isEmpty()) {
			Discount cek = new Discount();
			cek.setKode(diskon.getKode());
			cek.setPotongan(diskon.getPotongan());
			discountRepo.save(cek);
		}
	}

	@Override
	public void update(Discount diskon) throws Exception {
		List<Discount> cekKode = findKode(diskon.getKode());
		if (cekKode.isEmpty()) {
			Discount cek = new Discount();
			cek = findById(diskon.getDiscId());
			cek.setKode(diskon.getKode());
			cek.setPotongan(diskon.getPotongan());
			discountRepo.save(cek);
		}
	}

	@Override
	public void delete(Discount diskon) throws Exception {
		Discount cek = new Discount();
		cek = findById(diskon.getDiscId());
		discountRepo.delete(cek);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Discount> findKode(String kode) throws Exception {
		return (List<Discount>) discountRepo.findKode(kode);
	}

	@Override
	public Discount findById(Long id) throws Exception {
		return discountRepo.findById(id).orElse(null);
	}

	
}
