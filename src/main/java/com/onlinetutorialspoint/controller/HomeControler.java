package com.onlinetutorialspoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetutorialspoint.model.ResponceObject;
import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.pojo.LoginDetails;
import com.onlinetutorialspoint.service.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(value = "/home")
@CrossOrigin(origins = "*")
public class HomeControler {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login")
	public ResponceObject create(@RequestBody LoginDetails loginDetails) {
		ResponceObject responceObject=new ResponceObject();
		try {
			System.out.println(loginDetails.getPassword());
			System.out.println(loginDetails.getUserName());
			User user=loginService.loginUser(loginDetails);
			System.out.println(user);
			if(user != null) {
				responceObject.setErrorCode("00");
				responceObject.setData(user.getUserDetails());
			}else {
				responceObject.setErrorCode("01");
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return responceObject;
	}
	@RequestMapping(value = "/getAllUser")
	public ResponceObject getAllUser() {
		ResponceObject responceObject=new ResponceObject();
		try {
			List<User> user=loginService.getAllUser();
			if(user != null) {
				responceObject.setErrorCode("00");
				responceObject.setData(user);
			}else {
				responceObject.setErrorCode("01");
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return responceObject;
	}
	@RequestMapping(value = "/deleteUser")
	public ResponceObject deleteUser(@RequestBody User user) {
		ResponceObject responceObject=new ResponceObject();
		try {
			boolean returnValue=loginService.deleteUser(user);
			if(returnValue) {
				responceObject.setErrorCode("00");
			
			}else {
				responceObject.setErrorCode("01");
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return responceObject;
	}
	
//	@RequestMapping(value = "/save")
//	public ResponceObject create(@RequestBody User user) {
//		ResponceObject responceObject=new ResponceObject();
//		try {
//			User userDetails=loginService.save(user);
//			System.out.println(userDetails);
//			if(userDetails != null) {
//				responceObject.setErrorCode("00");
//				responceObject.setData(userDetails);
//			}else {
//				responceObject.setErrorCode("01");
//			}
//			
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//		return responceObject;
//	}
}
