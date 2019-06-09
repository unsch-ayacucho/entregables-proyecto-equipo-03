package edu.pe.unsch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unsch.dao.CategoriaDao;
import edu.pe.unsch.entities.Categoria;

@Service("categoryService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}

}
