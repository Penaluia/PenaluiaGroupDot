package com.financiamiento.calculo;

public class Prestamo {
	
	private String socio;
	private double cuota_mensual;
	private double pago_total;
	private double tasa_mensual;
	
	
	public String getSocio() {
		return socio;
	}
	public void setSocio(String socio) {
		this.socio = socio;
	}
	
	public double getCuota_mensual() {
		return cuota_mensual;
	}	
	public void setCuota_mensual(double cuota_mensual) {
		this.cuota_mensual = cuota_mensual;
	}
	
	public double getPago_total() {
		return pago_total;
	}
	public void setPago_total(double pago_total) {
		this.pago_total = pago_total;
	}
	
	public double getTasa_mensual() {
		return tasa_mensual;
	}
	public void setTasa_mensual(double tasa_mensual) {
		this.tasa_mensual = tasa_mensual;
	}
}