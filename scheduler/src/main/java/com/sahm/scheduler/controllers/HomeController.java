package com.sahm.scheduler.controllers;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sahm.scheduler.model.entity.DtPassword;
import com.sahm.scheduler.model.repository.DtPasswordRepository;

@Controller
public class HomeController {
	
	@Autowired
	private DtPasswordRepository dtPasswordRepository;
	
	@RequestMapping(value="/")
	public String hello(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, 
			@RequestParam("email") String email, 
			@RequestParam("password") String password,
			HttpServletRequest request) {
		
		try {
			DtPassword dtPassword = dtPasswordRepository.findByEmail(email);
			String DsPassword = dtPassword.getDsPassword();
			
			if (password.equals(DsPassword)) {
				
				request.getSession().setAttribute("userEmail", email);
				request.getSession().setAttribute("AccountType", dtPassword.getDiAccountType());
				
				model.addAttribute("AccountType", dtPassword.getDiAccountType());
				model.addAttribute("userEmail", email);
				return "forward:/calendar";
			}			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return "index";
		}
		
		return "index";
	}
}
