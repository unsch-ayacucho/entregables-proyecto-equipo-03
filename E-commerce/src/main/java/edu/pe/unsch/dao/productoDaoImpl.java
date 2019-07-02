package edu.pe.unsch.dao;

import java.util.List;

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

	@Override
	public List<Producto> featured(int n) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Producto"
										+ " where destacado =: feature "
										+ " order by id desc",Producto.class)
										.setParameter("feature", (boolean) true)
										.setMaxResults(n)
										.getResultList();
	}

	@Override
	public List<Producto> lasted(int n) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Producto"
										+" where oferta =: oferta " 
										+" order by id desc", Producto.class)
										.setParameter("oferta", (boolean) true)
										.setMaxResults(n)
										.getResultList();
	}

}
