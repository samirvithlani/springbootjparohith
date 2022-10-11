package com.service;

import org.springframework.stereotype.Service;

import com.bean.LoginBean;
import com.bean.UserBean;

@Service
public interface LoginService {

	public UserBean loginUser(LoginBean loginBean);

}
