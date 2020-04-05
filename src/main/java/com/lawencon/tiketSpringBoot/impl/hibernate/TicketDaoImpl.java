package com.lawencon.tiketSpringBoot.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TicketDao;
import com.lawencon.tiketSpringBoot.model.Ticket;

@Repository("ticket_repo_hibernate")
public class TicketDaoImpl extends CustomRepo implements TicketDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAll() {
		Query q = em.createQuery("from Ticket");
		return q.getResultList();
	}

	@Override
	public void delete(Ticket tiket) throws Exception {
		Ticket cek = new Ticket();
		cek = findById(tiket.getTicketId());
		em.remove(cek);
	}
	
	@Override
	public Ticket findById(Long id) throws Exception {
		Query q = em.createQuery(" from Ticket where ticketId =:idParam");
		q.setParameter("idParam", id);
		return (Ticket) q.getSingleResult();
	}

}
