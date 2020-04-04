package com.lawencon.tiketSpringBoot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lawencon.tiketSpringBoot.model.Discount;

public interface DiscountService {

	abstract List<Discount> findAll(String au0, String au1) throws Exception;
	abstract ResponseEntity<?> insert(Discount diskon, String au0, String au1) throws Exception;
	abstract void update(Discount diskon, String au0, String au1) throws Exception;
	abstract void delete(Discount diskon, String au0, String au1) throws Exception;
}
