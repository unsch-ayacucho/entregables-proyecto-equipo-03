package edu.pe.unsch.service;

import edu.pe.unsch.entities.Usuario;

public interface AccountService {

	public void create(Usuario account);
	
	public Usuario login(String email, String password);
}
