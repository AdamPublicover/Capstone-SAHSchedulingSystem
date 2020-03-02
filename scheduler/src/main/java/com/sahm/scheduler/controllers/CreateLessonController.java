package com.sahm.scheduler.controllers;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreateLessonController {
	
	@RequestMapping(value="/create_lesson")
	public String hello(Model model) {
		return "create_lesson";
	}
}
