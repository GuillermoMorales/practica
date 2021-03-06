package com.uca.capas.parcialp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcialp.dao.ContribuyenteDAO;
import com.uca.capas.parcialp.domain.Contribuyente;


@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException
	{
		return contribuyenteDAO.findAll();
	}
	
	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException{
		return contribuyenteDAO.findOne(code);
	}
	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException
	{
		contribuyenteDAO.save(contribuyente);
	}
	
	@Override
	@Transactional
	public void delete (Integer codigoContribuyente) throws DataAccessException
	{
		contribuyenteDAO.delete(codigoContribuyente);
	}


}
