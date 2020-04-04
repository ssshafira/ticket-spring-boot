package com.lawencon.tiketSpringBoot.impl.hibernate;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TicketDao;
import com.lawencon.tiketSpringBoot.model.Ticket;

@Repository("ticket_repo_hibernate")
public class TicketDaoImpl extends CustomRepo implements TicketDao {

	@Override
	public void insert(Ticket tiket) {
		Ticket cek = new Ticket();
		cek.setAsal(tiket.getAsal());
		cek.setBerangkat(tiket.getBerangkat());
		cek.setKursi(tiket.getKursi());
		cek.setTipe(tiket.getTipe());
		cek.setTujuan(tiket.getTujuan());
		cek.setDiskon(tiket.getDiskon());
		cekDiskon(tiket.getDiskon(), cek);
		em.persist(cek);
	}

	@Override
	public void cekDiskon(String diskon, Ticket tiket) {
		try {
			Query q = em.createQuery("select kode from Discount where kode =:kodeParam");
			q.setParameter("kodeParam", diskon);
			int pot;
			Query d = em.createQuery("select potongan from Discount where kode =:kodeParam");
			d.setParameter("kodeParam", tiket.getDiskon());
			pot = (int) d.getSingleResult();
			tiket.setHarga(getHargaByTipe(tiket) - pot);
		} catch (Exception e) {
			tiket.setDiskon("-");
			tiket.setHarga(getHargaByTipe(tiket));
		}
	}

	@Override
	public int getHargaByTipe(Ticket tiket) {
		Query q = em.createQuery("select harga from Type where typeId =:idParam");
		q.setParameter("idParam", tiket.getTipe().getTypeId());
		return (int) q.getSingleResult();
	}

}
