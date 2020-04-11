package com.sahm.scheduler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventInfoController {
	
	@RequestMapping(value="/eventinfo", method=RequestMethod.GET)
	public String eventInfoPage(Model model) {
		return "eventinfo";
	}

}
