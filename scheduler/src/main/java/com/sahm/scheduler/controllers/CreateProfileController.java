package com.sahm.scheduler.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.Convert;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sahm.scheduler.model.entity.DtParent;
import com.sahm.scheduler.model.entity.DtPassword;
import com.sahm.scheduler.model.entity.DtTeacher;
import com.sahm.scheduler.model.repository.DtParentRepository;
import com.sahm.scheduler.model.repository.DtPasswordRepository;
import com.sahm.scheduler.model.repository.DtTeacherRepository;

@Controller
public class CreateProfileController {
	
	@Autowired
	DtParentRepository dtParentRepository;
	
	@Autowired
	DtTeacherRepository dtTeacherRepository;
	
	@Autowired
	DtPasswordRepository dtPasswordRepository;
	
	@RequestMapping(value="/create_profile_a")
	public String hello(Model model) {
		return "create_profile_a";
	}
	
	@RequestMapping(value="/create_profile_a/create", method=RequestMethod.POST)
	public String create(@RequestParam("email") String email, 
			@RequestParam("account") String account,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		
		int accountType = Integer.parseInt(account);

		
		// Password configuration
		DtPassword dtPassword = new DtPassword();

		dtPassword.setDsEmail(email);
		dtPassword.setDiAccountType(accountType);
		dtPassword.setDsPassword("temp_password");
					
		
		if (accountType == 2) {
			// Teacher configuration
			DtTeacher dtTeacher = new DtTeacher();
			
			dtTeacher.setEmail(email);
			dtTeacher.setFName(firstName);
			dtTeacher.setLName(lastName);
			
			dtTeacherRepository.save(dtTeacher);
			
		} else if (accountType == 3) {
			// Parent configuration
			DtParent dtParent = new DtParent();
			
			dtParent.setEmail(email);
			dtParent.setFirstName(firstName);
			dtParent.setLastName(lastName);
			dtParent.setAddress("");
			dtParent.setPhoneNum("");
			
			dtParentRepository.save(dtParent);
		}
		
		return "calendar";
	}
	
}
