package com.lawencon.tiketSpringBoot.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TypeDao;
import com.lawencon.tiketSpringBoot.model.Type;

@Repository("type_repo_jpa")
public class TypeDaoImpl implements TypeDao {
	
	@Autowired
	private TypeRepo typeRepo;

	@Override
	public List<Type> findAll() throws Exception {
		return typeRepo.findAll();
	}

	@Override
	public void insert(Type tipe) throws Exception {
		List<Type> cekTipe = findType(tipe.getJenis());
		if (cekTipe.isEmpty()) {
			Type cek = new Type();
			cek.setJenis(tipe.getJenis());
			cek.setHarga(tipe.getHarga());
			typeRepo.save(cek);
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
			typeRepo.save(cek);
		}
	}

	@Override
	public void delete(Type tipe) throws Exception {
		Type cek = new Type();
		cek = findById(tipe.getTypeId());
		typeRepo.delete(cek);
	}

	@Override
	public List<Type> findType(String type) throws Exception {
		return typeRepo.findType(type);
	}

	@Override
	public Type findById(Long id) throws Exception {
		return typeRepo.findById(id).orElse(null);
	}

	
}
