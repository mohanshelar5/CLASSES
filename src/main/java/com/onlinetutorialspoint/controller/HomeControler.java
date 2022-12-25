package com.onlinetutorialspoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetutorialspoint.model.ResponceObject;
import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.pojo.LoginDetails;
import com.onlinetutorialspoint.service.LoginService;

@RestController
@RequestMapping(value = "/home")
public class HomeControler {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login")
	public ResponceObject create(@RequestBody LoginDetails loginDetails) {
		ResponceObject responceObject=new ResponceObject();
		try {
			User user=loginService.loginUser(loginDetails);
			responceObject.setErrorCode("00");
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return responceObject;
	}
}
