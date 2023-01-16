package com.onlinetutorialspoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetutorialspoint.model.ResponceObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.onlinetutorialspoint.model.UserDetails;
import com.onlinetutorialspoint.service.TeacherService;

@RestController
@RequestMapping(value = "/teacher")
@CrossOrigin(origins = "*")
public class TeacherControler {	
	@Autowired
	private TeacherService teacherService;
@RequestMapping(value = "/save")
public ResponceObject create(@RequestBody UserDetails userDetails) {
	ResponceObject responceObject=new ResponceObject();
	try {
		List<UserDetails> user=teacherService.save(userDetails);
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
			List<UserDetails> userDetails=teacherService.getAllTeacher();
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
	}}
