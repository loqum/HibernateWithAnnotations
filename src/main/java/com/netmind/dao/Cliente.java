package com.netmind.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "IdCliente")
	private int idCliente;
	@Column(name = "Nombre")
	private String nombre;
	@Column(name = "Apellidos")
	private String apellidos;
	@Column(name = "Dni")
	private String dni;

	public Cliente() {

	}

	public Cliente(int idCliente, String nombre, String apellidos, String dni) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

}
