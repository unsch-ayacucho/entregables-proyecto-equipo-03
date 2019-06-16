package edu.pe.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Categoria;

@Repository("categoryDao")
public class CategoriaDaoImpl implements CategoriaDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		
		final Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("----------------------------------------------------------------------------");
		//List<Categoria>x= 
			return	entityManager
				.createQuery("from Categoria where idPadre=0",Categoria.class)
				.getResultList();
		
		
	}

	@Override
	public Categoria find(Integer id) {
		// TODO Auto-generated method stub
		return (Categoria) entityManager.find(Categoria.class, id);
	}

}
