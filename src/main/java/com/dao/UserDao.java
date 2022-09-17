package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;
import com.service.UserRepository;
import com.service.UserService;

@Repository
public class UserDao implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public int addUser(UserBean userBean) {
		int res = 0;
		try {

			userRepository.save(userBean);
			res = 1;
		} catch (Exception e) {

			res = -1;
		}
		return res;
	}

	@Override
	public UserBean getUserById(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> getAllUsers() {

		return userRepository.findAll();
	}

}
