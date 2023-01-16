package com.onlinetutorialspoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetutorialspoint.model.ResponceObject;
import com.onlinetutorialspoint.model.UserDetails;
import com.onlinetutorialspoint.service.StaffService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(value = "/staff")
@CrossOrigin(origins = "*")
public class StaffController {
	@Autowired
	private StaffService staffService;
	@RequestMapping(value = "/save")
	public ResponceObject create(@RequestBody UserDetails userDetails) {
		ResponceObject responceObject=new ResponceObject();
		try {
			List<UserDetails> user=staffService.save(userDetails);
			
			if(user.size()>0) {
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
	@RequestMapping(value = "/getAllStaff")
	public ResponceObject create() {
		ResponceObject responceObject=new ResponceObject();
		try {
			List<UserDetails> userDetails=staffService.getAllStaff();
			if(userDetails.size()>0) {
				responceObject.setErrorCode("00");
				responceObject.setData(userDetails);
			}else {
				responceObject.setErrorCode("01");
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return responceObject;
	}
}
