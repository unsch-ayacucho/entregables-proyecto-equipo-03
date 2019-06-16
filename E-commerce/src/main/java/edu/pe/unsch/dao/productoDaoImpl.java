package edu.pe.unsch.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Producto;

@Repository("productoDao")
public class productoDaoImpl implements ProductoDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Producto find(Integer id) {
		// TODO Auto-generated method stub
		return (Producto) entityManager.find(Producto.class, id);
	}

}
