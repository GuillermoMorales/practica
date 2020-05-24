package com.uca.capas.parcialp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcialp.domain.Contribuyente;


@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		javax.persistence.Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> resulset = query.getResultList();
		
		return resulset;
	}
	
	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException
	{
		try
		{
			if(contribuyente.getCodigoContribuyente() == null)
			{
				entityManager.persist(contribuyente);
			}
			else
			{
				entityManager.merge(contribuyente);
				entityManager.flush();
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public void delete(Integer codigoContribuyente) throws DataAccessException
	{
		Contribuyente contribuyente= entityManager.find(Contribuyente.class, codigoContribuyente);
		entityManager.remove(contribuyente);
	}
	
	
	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException
	{
		Contribuyente contribuyente= entityManager.find(Contribuyente .class, code);
		return contribuyente;
	}

	
	

}
