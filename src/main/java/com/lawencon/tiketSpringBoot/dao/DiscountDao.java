package com.lawencon.tiketSpringBoot.dao;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Discount;

public interface DiscountDao {

	abstract List<Discount> findAll() throws Exception;
	abstract void insert(Discount diskon) throws Exception;
	abstract void update(Discount diskon) throws Exception;
	abstract void delete(Discount diskon) throws Exception;
	abstract List<Discount> findKode(String kode) throws Exception;
	abstract Discount findById(Long id) throws Exception;
}
