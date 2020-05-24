package com.uca.capas.parcialp.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcialp.domain.Importancia;

public interface ImportanciaService {
	

public List<Importancia> findAll()throws DataAccessException;
	
	public Importancia findOne(Integer code) throws DataAccessException;

}
