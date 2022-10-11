package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.service.LoginService;
import com.service.ResponseManager;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping(value = "/loginuser")
	public ResponseEntity<?> loginUser(@RequestBody LoginBean loginBean) {

		ResponseManager responseManager = new ResponseManager();
		UserBean userBean = loginService.loginUser(loginBean);

		if (userBean != null) {

			responseManager.setCode(HttpStatus.OK);
			responseManager.setObject(userBean);
			responseManager.setStatus("User Found !");

			return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.OK);

		}
		responseManager.setCode(HttpStatus.EXPECTATION_FAILED);
		responseManager.setObject(null);
		responseManager.setStatus("User Not Found !");

		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.EXPECTATION_FAILED);

	}
}
