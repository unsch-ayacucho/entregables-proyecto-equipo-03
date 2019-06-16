package edu.pe.unsch.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unsch.dao.ProductoDao;
import edu.pe.unsch.entities.Producto;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public Producto find(Integer id) {
		// TODO Auto-generated method stub
		return productoDao.find(id);
	}

	
}
