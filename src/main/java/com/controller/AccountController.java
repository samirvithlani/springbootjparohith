package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.service.AccountService;
import com.service.ResponseManager;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping(value = "/account")
	public ResponseEntity<?> addAccount(@RequestBody AccountBean accountBean) {

		ResponseManager responseManager = new ResponseManager();
		int res = accountService.addAcoount(accountBean);
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
}
