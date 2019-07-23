package edu.pe.unsch.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unsch.dao.OrdersDetailDao;
import edu.pe.unsch.entities.Detallecompra;

@Service("ordersDetailService")
@Transactional
public class OrdersDetailServiceImpl implements OrdersDetailService{

	
	@Autowired
	private OrdersDetailDao ordersDetailDao;
	
	@Override
	public void create(Detallecompra ordersdetail) {
		// TODO Auto-generated method stub
		ordersDetailDao.create(ordersdetail);
		
	}

	
}
