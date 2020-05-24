package com.uca.capas.parcialp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcialp.dao.ContribuyenteDAO;
import com.uca.capas.parcialp.dao.ImportanciaDAO;
import com.uca.capas.parcialp.domain.Contribuyente;
import com.uca.capas.parcialp.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService {
	
	@Autowired
	ImportanciaDAO importanciaDAO;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException
	{
		return importanciaDAO.findAll();
	}
	
	@Override
	public Importancia findOne(Integer code) throws DataAccessException{
		return importanciaDAO.findOne(code);
	}

}
