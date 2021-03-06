package edu.pe.unsch.service;

import java.util.List;

import edu.pe.unsch.entities.Producto;

public interface ProductoService {

	public Producto find(Integer id);
	
	public List<Producto> featured(int n);
	
	public List<Producto> lasted(int n);
}
