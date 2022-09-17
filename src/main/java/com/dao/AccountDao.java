package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.service.AccountRepository;
import com.service.AccountService;

@Repository
public class AccountDao implements AccountService {

	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public int addAcoount(AccountBean accountBean) {
		int res =0;
		try {
			accountRepository.save(accountBean);
			res = 1;
			
		}catch (Exception e) {
			
			res = -1;
		}
		return res;
	}

	@Override
	public AccountBean getAccountById(int aId) {
		
		return accountRepository.getById(aId);
	}

	@Override
	public List<AccountBean> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
