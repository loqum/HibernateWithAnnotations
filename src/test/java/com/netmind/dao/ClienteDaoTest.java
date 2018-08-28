package com.netmind.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ClienteDaoTest {

	private Cliente cliente;
	private ClienteDao clienteDao;
	@SuppressWarnings("unused")
	private static int IDCLIENTE = 0;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testAdd() throws Exception {

		cliente = new Cliente();
		cliente.setIdCliente(1);
		cliente.setNombre("Ruben");
		cliente.setApellidos("Fernandez");
		cliente.setDni("47662275L");
		clienteDao = new ClienteDao();
		Cliente expectedReturn = clienteDao.add(cliente);
		IDCLIENTE = expectedReturn.getIdCliente();
		assertTrue(expectedReturn != null);
		assertTrue(IDCLIENTE > 0);

	}

	@Test
	public void testModify() throws Exception {
		cliente = new Cliente();
		cliente.setIdCliente(IDCLIENTE);
		cliente.setNombre("Adrià");
		cliente.setApellidos("Claret");
		cliente.setDni("44723275L");
		clienteDao = new ClienteDao();
		Cliente clienteExpected = clienteDao.modify(cliente);
		assertTrue(clienteExpected != null);
		assertTrue(clienteExpected.getNombre().equals("Adrià"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAll() throws Exception {
		List<Cliente> expectedReturn = clienteDao.getAll();
		clienteDao = new ClienteDao();
		assertTrue(expectedReturn != null);
		assertTrue(expectedReturn.size() > 0);
	}
	
	@Test
	public void testGetById() throws Exception {
		clienteDao = new ClienteDao();
		Cliente expectedReturn = clienteDao.getById(IDCLIENTE);
		assertTrue(expectedReturn != null);
	}
	
	
	@Test
	public void testRemove() throws Exception {
		clienteDao = new ClienteDao();
		int clienteExpected = clienteDao.remove(IDCLIENTE);
		assertTrue(clienteExpected > 0);
	}
}
