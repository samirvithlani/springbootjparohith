package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.UserBean;

@Service
public interface UserService {

	public int addUser(UserBean userBean);

	public UserBean getUserById(int uId);

	public List<UserBean> getAllUsers();

}
