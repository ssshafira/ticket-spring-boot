package com.lawencon.tiketSpringBoot.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TypeDao;
import com.lawencon.tiketSpringBoot.model.Type;

@Repository("type_repo_hibernate")
public class TypeDaoImpl extends CustomRepo implements TypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findAll() throws Exception {
		Query q = em.createQuery("from Type");
		return q.getResultList();
	}

	@Override
	public void insert(Type tipe) throws Exception {
		List<Type> cekTipe = findType(tipe.getJenis());
		if (cekTipe.isEmpty()) {
			Type cek = new Type();
			cek.setJenis(tipe.getJenis());
			cek.setHarga(tipe.getHarga());
			em.persist(cek);
		} else {
			System.out.println("tipe sudah ada");
		}
	}

	@Override
	public void update(Type tipe) throws Exception {
		List<Type> cekTipe = findType(tipe.getJenis());
		if (cekTipe.isEmpty()) {
			Type cek = new Type();
			cek = findById(tipe.getTypeId());
			cek.setJenis(tipe.getJenis());
			cek.setHarga(tipe.getHarga());
			em.merge(cek);
		} else {
			System.out.println("tipe sudah ada");
		}
	}

	@Override
	public void delete(Type tipe) throws Exception {
		Type cek = new Type();
		cek = findById(tipe.getTypeId());
		em.remove(cek);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findType(String type) throws Exception {
		Query q = em.createQuery("select jenis from Type where jenis =:jenisParam");
		q.setParameter("jenisParam", type);
		return q.getResultList();
	}

	@Override
	public Type findById(Long id) throws Exception {
		Query q = em.createQuery(" from Type where typeId =:idParam");
		q.setParameter("idParam", id);
		return (Type) q.getSingleResult();
	}

	
}
