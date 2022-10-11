package com.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.bean.UserBean;

@Service
public interface LoginRepository extends JpaRepository<UserBean, Integer> {

	public UserBean findByuEmailAndPassword(String uEmail, String ePassword);
}
