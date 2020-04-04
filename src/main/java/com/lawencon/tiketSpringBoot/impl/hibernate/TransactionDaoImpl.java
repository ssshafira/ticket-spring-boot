package com.lawencon.tiketSpringBoot.impl.hibernate;


import org.springframework.stereotype.Repository;

import com.lawencon.tiketSpringBoot.dao.TransactionDao;

@Repository("trans_repo_hibernate")
public class TransactionDaoImpl extends CustomRepo implements TransactionDao {

	
}
