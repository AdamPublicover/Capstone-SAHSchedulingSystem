package com.sahm.scheduler.controllers;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import org.daypilot.ui.DayPilotCalendar;


@Controller
public class CalendarController extends HttpServlet {
private static final long serialVersionUID = 1L;

	@RequestMapping(value="/calendar")
	public String hello(Model model) {
		return "calendar";
	}
}
