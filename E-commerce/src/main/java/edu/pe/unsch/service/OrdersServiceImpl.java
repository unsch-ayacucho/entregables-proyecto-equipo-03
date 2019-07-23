package edu.pe.unsch.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unsch.dao.OrdersDao;
import edu.pe.unsch.entities.Compra;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	public Compra create(Compra orders) {
		// TODO Auto-generated method stub
		return ordersDao.create(orders);
	}

	
}
