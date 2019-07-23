package edu.pe.unsch.dao;

import edu.pe.unsch.entities.Usuario;

public interface AccountDao {

	public void create(Usuario account);
	
	public Usuario find(String email);
	
	public Usuario login(String email, String password);
}
