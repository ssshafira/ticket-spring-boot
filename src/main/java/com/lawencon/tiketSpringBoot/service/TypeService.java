package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lawencon.tiketSpringBoot.model.Type;

public interface TypeService {

	abstract List<Type> findAll(String au0, String au1) throws Exception;
	abstract ResponseEntity<?> insert(Type tipe, String au0, String au1) throws Exception;
	abstract void update(Type tipe, String au0, String au1) throws Exception;
	abstract void delete(Type tipe, String au0, String au1) throws Exception;
}
