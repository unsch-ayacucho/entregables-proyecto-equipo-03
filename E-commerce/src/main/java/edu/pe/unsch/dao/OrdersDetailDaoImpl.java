package edu.pe.unsch.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Detallecompra;

@Repository("ordersDetailDao")
public class OrdersDetailDaoImpl implements OrdersDetailDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(Detallecompra ordersdetail) {
		// TODO Auto-generated method stub
		entityManager.persist(ordersdetail);
	}
	
}
