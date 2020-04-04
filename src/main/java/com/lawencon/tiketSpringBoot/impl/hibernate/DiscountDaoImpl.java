package com.lawencon.tiketSpringBoot.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.DiscountDao;
import com.lawencon.tiketSpringBoot.model.Discount;

@Repository("discount_repo_hibernate")
public class DiscountDaoImpl extends CustomRepo implements DiscountDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Discount> findAll() throws Exception {
		Query q = em.createQuery("from Discount");
		return q.getResultList();
	}

	@Override
	public void insert(Discount diskon) throws Exception {
		List<Discount> cekKode = findKode(diskon.getKode());
		if (cekKode.isEmpty()) {
			Discount cek = new Discount();
			cek.setKode(diskon.getKode());
			cek.setPotongan(diskon.getPotongan());
			em.persist(cek);
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
			em.merge(cek);
		}
	}

	@Override
	public void delete(Discount diskon) throws Exception {
		Discount cek = new Discount();
		cek = findById(diskon.getDiscId());
		em.remove(cek);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Discount> findKode(String kode) throws Exception {
		Query q = em.createQuery("select kode from Discount where kode =:kodeParam");
		q.setParameter("kodeParam", kode);
		return q.getResultList();
	}

	@Override
	public Discount findById(Long id) throws Exception {
		Query q = em.createQuery(" from Discount where discId =:idParam");
		q.setParameter("idParam", id);
		return (Discount) q.getSingleResult();
	}
	
}
