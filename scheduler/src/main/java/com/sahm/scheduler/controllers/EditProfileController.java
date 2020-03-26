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

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sahm.scheduler.model.entity.DtTeacher;
import com.sahm.scheduler.model.repository.DtTeacherRepository;

@Controller
public class EditProfileController {
	
	
	@Autowired
	DtTeacherRepository dtTeacherRepository;
	
	@RequestMapping(value="/edit_profile")
	public String hello(Model model) {
		return "edit_profile";
	}
	
	@RequestMapping(value="/edit_profile/submit", method=RequestMethod.POST)
	public String updateInformation(Model model,
			HttpServletRequest request,
			@RequestParam(value="fName", required=false) String firstName,
			@RequestParam(value="lName", required=false) String lastName,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="address", required=false) String address,
			@RequestParam(value="phone", required=false) String phone ) {
		
		String TeacherEmail = (String) request.getSession().getAttribute("userEmail");
		
		try {
			DtTeacher account = dtTeacherRepository.findByDsEmail(TeacherEmail);
			
			System.out.println(email);
			System.out.println(firstName);
			System.out.println(lastName);
			
			if (email != null && email != "") { account.setEmail(email); }
			if (firstName != null && firstName != "") { account.setFName(firstName); }
			if (lastName != null && lastName != "") {account.setLName(lastName); }
			
			dtTeacherRepository.save(account);
			
			return "calendar";
		
		} catch ( Exception e ) {
			System.out.println("Number Format Exception?");
			System.out.println(e);
			return "index";
		}
		
		
	}
	
}
