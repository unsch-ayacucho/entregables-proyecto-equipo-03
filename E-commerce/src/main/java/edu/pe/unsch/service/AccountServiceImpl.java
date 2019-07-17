package edu.pe.unsch.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unsch.dao.AccountDao;
import edu.pe.unsch.entities.Usuario;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void create(Usuario account) {
		// TODO Auto-generated method stub
		
		account.setAdmin((boolean) true);
		accountDao.create(account);
	}

	@Override
	public Usuario login(String email, String password) {
		// TODO Auto-generated method stub
		return accountDao.login(email, password);
	}

}
