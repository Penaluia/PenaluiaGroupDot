package com.financiamiento.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Socio {
	@Id
	@GeneratedValue
	
	@Column(name = "id")
	private int id;	
	@Column(name = "cedula")
	private int cedula;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "tasa")
	private double tasa;
	@Column(name = "monto_maximo")
	private int montoMaximo;
	
	
	public Socio() {
		
	}


	public Socio(int cedula, String nombre, double tasa, int montoMaximo) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.tasa = tasa;
		this.montoMaximo = montoMaximo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTasa() {
		return tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public int getMontoMaximo() {
		return montoMaximo;
	}
	public void setMontoMaximo(int montoMaximo) {
		this.montoMaximo = montoMaximo;
	}
}
