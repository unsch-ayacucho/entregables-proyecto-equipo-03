package edu.pe.unsch.service;

import java.util.List;

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

	@Override
	public List<Producto> featured(int n) {
		// TODO Auto-generated method stub
		return productoDao.featured(n);
	}

	@Override
	public List<Producto> lasted(int n) {
		// TODO Auto-generated method stub
		return productoDao.lasted(n);
	}

	
}
