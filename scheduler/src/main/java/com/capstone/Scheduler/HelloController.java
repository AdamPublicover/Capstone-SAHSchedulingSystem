package com.capstone.Scheduler;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * We will delete this at a later date - for now this controller is necessary so
 * Spring understands to run the project on an embedded Tomcat server within eclipse.
 * Super cool to be honest!!!!!!!!
 */

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}