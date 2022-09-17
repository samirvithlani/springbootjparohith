package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.AccountBean;

@Service
public interface AccountService {

	public int addAcoount(AccountBean accountBean);
	public AccountBean getAccountById(int aId);
	public List<AccountBean> getAllAccounts();
	
}
