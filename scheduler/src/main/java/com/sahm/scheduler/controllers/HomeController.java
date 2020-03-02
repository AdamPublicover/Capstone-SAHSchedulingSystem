package com.sahm.scheduler.controllers;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String hello(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login(Model model) {
		return "calendar";
	}
	
	/*
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("login method has been hit");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email + ", " + password);
		
		if (email == "admin@isp.net") {
			System.out.println("Credentials correct . . . ");
			
			HttpSession session = request.getSession(true);
			session.setAttribute("user", "Elliott");
			
			try { response.sendRedirect("calendar"); } 
			catch ( Exception e) { System.out.println(e + " happened"); }
			
			return "calendar";
		}
		return "index";
	}
	*/

}
