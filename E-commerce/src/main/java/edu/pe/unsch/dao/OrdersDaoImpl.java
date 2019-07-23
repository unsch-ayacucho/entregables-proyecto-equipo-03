package edu.pe.unsch.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Compra;

@Repository("ordersDao")
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Compra create(Compra orders) {
		// TODO Auto-generated method stub
		entityManager.persist(orders);
		return orders;
	}

	
}
