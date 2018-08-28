package com.netmind.dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void testGetSessionFactory() {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		trans = session.beginTransaction();
		assertNotNull(trans);
	}

}
