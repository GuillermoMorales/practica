package com.uca.capas.parcialp.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcialp.domain.Contribuyente;


public interface ContribuyenteService {

public List<Contribuyente> findAll()throws DataAccessException;
	
	public Contribuyente findOne(Integer code) throws DataAccessException;
	
	public void save(Contribuyente contribuyente) throws DataAccessException;
	
	public void delete(Integer codigoContribuyente) throws DataAccessException;
}
