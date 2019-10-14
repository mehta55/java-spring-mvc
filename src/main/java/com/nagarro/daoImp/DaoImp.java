package com.nagarro.daoImp;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.dao.Dao;

public class DaoImp implements Dao {

	final static Logger LOG = Logger.getLogger(DaoImp.class);
	
	private Configuration con = new Configuration().configure();
	private SessionFactory sessionFactory = con.buildSessionFactory();
	private Session session;

	public Session getSession() {
		return session;

	}

	public void begin() {
		LOG.info("Starting new session.");
		session = sessionFactory.openSession();

		LOG.info("Starting new transaction.");
		session.beginTransaction();

	}

	public void commit() {
		LOG.info("Committing transaction.");
		session.getTransaction().commit();

	}

	public void close() {
		LOG.info("Closing session.");
		session.close();

	}

	public void rollback() {
		LOG.info("Rollback transaction.");
		session.getTransaction().rollback();

	}

}
