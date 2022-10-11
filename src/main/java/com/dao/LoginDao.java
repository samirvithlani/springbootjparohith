package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.service.LoginRepository;
import com.service.LoginService;

@Repository
public class LoginDao implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	public UserBean loginUser(LoginBean loginBean) {

		return loginRepository.findByuEmailAndPassword(loginBean.getUserEmail(), loginBean.getUserPassword());
	}
}
