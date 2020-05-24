package com.uca.capas.parcialp.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcialp.domain.Contribuyente;
import com.uca.capas.parcialp.domain.Importancia;

public interface ImportanciaDAO{
	
public List<Importancia>findAll() throws DataAccessException;
	
	public Importancia findOne(Integer code) throws DataAccessException;

}
