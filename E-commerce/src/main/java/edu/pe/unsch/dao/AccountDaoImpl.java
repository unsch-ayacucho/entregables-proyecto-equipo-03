package edu.pe.unsch.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Usuario;


@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Usuario account) {
		// TODO Auto-generated method stub
		entityManager.persist(account);
	}

	@Override
	public Usuario login(String email, String password) {
		// TODO Auto-generated method stub
		try {
		return (Usuario) entityManager.createQuery(" from Usuario "
										+ " where email =: email and "
										+ " password =: password ")
										.setParameter("email", email)
										.setParameter("password", password)
										.getSingleResult();
		}catch(Exception e) {
			e.getMessage();
			System.out.println("catch");
			return null;
		}
	}

}
