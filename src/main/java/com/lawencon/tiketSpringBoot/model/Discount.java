package com.lawencon.tiketSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "disc_uk", columnNames = { "kode", "potongan" }) })
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long discId;

	private String kode;
	private int potongan;

	public Long getDiscId() {
		return discId;
	}

	public void setDiscId(Long discId) {
		this.discId = discId;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public int getPotongan() {
		return potongan;
	}

	public void setPotongan(int potongan) {
		this.potongan = potongan;
	}

}
