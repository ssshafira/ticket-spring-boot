package com.lawencon.tiketSpringBoot.dao;

import java.util.List;

import com.lawencon.tiketSpringBoot.model.Type;

public interface TypeDao {

	abstract List<Type> findAll() throws Exception;
	abstract void insert(Type tipe) throws Exception;
	abstract void update(Type tipe) throws Exception;
	abstract void delete(Type tipe) throws Exception;
	abstract List<Type> findType(String type) throws Exception;
	abstract Type findById(Long id) throws Exception;
}
