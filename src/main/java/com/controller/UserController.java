package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.UserBean;
import com.service.AccountService;
import com.service.ResponseManager;
import com.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	@PostMapping(value = "/user")
	public ResponseEntity<?> addUser(@RequestBody UserBean userBean) {

		// before add user we need to fetch Acciut object from account id;

//		int res =0;

		AccountBean accountBean = accountService.getAccountById(userBean.getaId());
		userBean.setAccounts(accountBean);

		int res = userService.addUser(userBean);
		ResponseManager responseManager = new ResponseManager();

		if (res > 0) {
			responseManager.setStatus("success");
			responseManager.setCode(HttpStatus.CREATED);
			responseManager.setObject(null);
			return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.CREATED);
		}
		responseManager.setStatus("failed");
		responseManager.setCode(HttpStatus.EXPECTATION_FAILED);
		responseManager.setObject(null);
		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/user")
	public ResponseEntity<?> getAllUsers() {

		List<UserBean> users = userService.getAllUsers();

		ResponseManager responseManager = new ResponseManager();
		if (users.size() > 0) {

			responseManager.setObject(users);
			return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
		}
		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.OK);

	}

}
