package com.groupdot.consultaMB;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


@ManagedBean (name="CreditoMB")
@SessionScoped

public class CreditoMB {
	
	private double valorSolicitado;
	private String datosDevueltos;
	private ArrayList<String> copiaDatos = new ArrayList<String>();
	
	
	public void calculoCredito()
	{
		System.out.println("El Valor Capturado es: " + valorSolicitado);
		
		
		Client cliente = ClientBuilder.newClient();
		
		WebTarget target = cliente.target("http://localhost:8080/financiamiento/consultarPrestamo/" + valorSolicitado); //Servicio que requiere como párametro el valor solicitado
		
		datosDevueltos = target.request(MediaType.APPLICATION_JSON).get(String.class);
		
		String[] division = datosDevueltos.split(",");
		String[] subDiv;
		
		for (int x=0; x < division.length; x++) {
			subDiv = division[x].split(":");
			for (int y=0; y < subDiv.length; y++) {
				copiaDatos.add(subDiv[y]);
			}
		}
	}
	

	public double getValorSolicitado() {
		return valorSolicitado;
	}
	public void setValorSolicitado(double valor) {
		this.valorSolicitado = valor;
	}

	public ArrayList<String> getCopiaDatos() {
		return copiaDatos;
	}
	public void setCopiaDatos(ArrayList<String> copiaDatos) {
		this.copiaDatos = copiaDatos;
	}
}