package com.financiamiento.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financiamiento.calculo.Prestamo;
import com.financiamiento.entidad.Socio;
import com.financiamiento.repositorio.SocioRepositorio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/financiamiento")
public class RecursoSocio {
	
	List<Socio> arraySocios = new ArrayList<Socio>();
	
	@Autowired
	
	private SocioRepositorio socioRepositorio;

/*	
	@GetMapping(value = "consultarTodo")
	public List<Socio> obtener(){
		
		arraySocios = socioRepositorio.findAll();
		
		for (Socio socio : arraySocios) {
			System.out.println(socio.getId());
		}
		
		return socioRepositorio.findAll();
	}
*/
	
	@GetMapping(value = "consultarPrestamo/{monto}")
	public String obtenerInt(@PathVariable(value = "monto") String vAS)
	{
		int x = 0;
		double vF = 0;		
		final Integer n = 36;
		Double vA = Double.parseDouble(vAS);
		String jsonFromPojo = "No Hay Socio Disponible!!";
		
		
		arraySocios = socioRepositorio.findAll();
		
		Prestamo prestamo = new Prestamo();
		
		for (Socio socio : arraySocios) {
			
			if(vA <= arraySocios.get(x).getMontoMaximo()) {
				
				vF = vA*(1+n*(arraySocios.get(x).getTasa()/100));
				
				prestamo.setPago_total(vF);
				prestamo.setCuota_mensual(vF/n);
				prestamo.setTasa_mensual(arraySocios.get(x).getTasa());
				prestamo.setSocio(arraySocios.get(x).getNombre());
				
				Gson gsonBuilder = new GsonBuilder().create();
				jsonFromPojo = gsonBuilder.toJson(prestamo);
			}
			else {
				x=x+1;
			}
		}
		return jsonFromPojo;
	}
}