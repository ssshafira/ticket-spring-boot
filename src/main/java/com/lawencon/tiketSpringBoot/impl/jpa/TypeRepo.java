package com.lawencon.tiketSpringBoot.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.model.Type;

@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {

	@Query("Select t from Type t where jenis =?1")
	public List<Type> findType(String type);
}
