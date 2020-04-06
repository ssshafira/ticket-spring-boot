package com.lawencon.tiketSpringBoot.controller;

import java.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController<T> {
	
	T model;

	public String[] authUser(String auth) {
		byte[] decodedBytes = Base64.getDecoder().decode(auth);
		String decodedString = new String(decodedBytes);
		String[] authArr = decodedString.split(":");
		return authArr;
	}
	
	public T readValue(String content, Class<T> kelas) throws Exception {
		return new ObjectMapper().readValue(content, kelas);
	}

}