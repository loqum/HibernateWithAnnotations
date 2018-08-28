package com.netmind.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao implements IDao<Cliente> {

	Session session = null;

	public Cliente add(Cliente cliente) throws HibernateException {
		Transaction trans = null;
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			trans = session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
			throw e;

		} finally {
			session.flush();
			session.close();
		}
		return cliente;
	}

	public Cliente modify(Cliente cliente) throws HibernateException {
		Cliente clienteExtraido = null;
		Transaction trans = null;
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			trans = session.beginTransaction();
			clienteExtraido = (Cliente) session.get(Cliente.class, cliente.getIdCliente());
			clienteExtraido.setNombre(cliente.getNombre());
			clienteExtraido.setApellidos(cliente.getApellidos());
			clienteExtraido.setDni(cliente.getDni());

			session.save(clienteExtraido);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
			throw e;
		} finally {
			session.flush();
			session.close();
		}
		return clienteExtraido;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAll() throws HibernateException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			clientes = session.createQuery("from cliente").list();
			trans.commit();

		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
			throw e;

		} finally {
			session.flush();
			session.close();
		}

		return clientes;
	}

	public Cliente getById(int idCliente) throws HibernateException {

		Cliente cliente = null;
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			String queryString = "from Cliente where idCliente = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", idCliente);
			cliente = (Cliente) query.uniqueResult();

		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;

		} finally {
			session.flush();
			session.close();
		}
		return cliente;
	}

	public int remove(int idCliente) throws HibernateException {
		Transaction trans = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			trans = session.beginTransaction();
			Cliente cliente = (Cliente) session.load(Cliente.class, new Integer(idCliente));
			session.delete(cliente);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
			throw e;

		} finally {
			session.flush();
			session.close();
		}
		return idCliente;
	}

}
