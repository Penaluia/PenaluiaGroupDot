package com.financiamiento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financiamiento.entidad.Socio;

public interface SocioRepositorio extends JpaRepository<Socio, Integer> 
{

}