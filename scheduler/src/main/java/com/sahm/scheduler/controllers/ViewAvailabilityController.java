package com.sahm.scheduler.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sahm.scheduler.model.entity.DtTeacherAvailability;
import com.sahm.scheduler.model.entity.Event;
import com.sahm.scheduler.model.repository.DtTeacherAvailabilityRepository;
import com.sahm.scheduler.model.repository.DtTeacherRepository;

import flexjson.JSONSerializer;

@Controller
public class ViewAvailabilityController {
	@Autowired
	DtTeacherAvailabilityRepository dtTeacherAvailabilityRepository;
	
	@Autowired
	DtTeacherRepository dtTeacherRepository;
	
	@RequestMapping(value="/view_availability")
	public String hello(Model model) {
		List<String> myTeachers = getTeachers();
		model.addAttribute("teachers", myTeachers);
		
		return "view_availability";
	}
	
	
	@RequestMapping(value="/view_availability/teacher", method=RequestMethod.POST)
	public String declareTeacher(Model model,
			@RequestParam(value="teachers", required=false) String teacher,
			HttpServletRequest request) {
		// The teacher is already in email form!!!!
		request.getSession().setAttribute("teacherAvailability", teacher);
		return "view_availability_calendar";
	}
	
	@RequestMapping(value="/view_availability/calendar", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public ResponseEntity<String> getCalendarEvents(HttpServletRequest request){
		String forTeacher = (String) request.getSession().getAttribute("teacherAvailability");

		List<DtTeacherAvailability> eventList = new ArrayList<>();
		eventList = dtTeacherAvailabilityRepository.findByDsteacheremail(forTeacher);
		
		List<Event> events = new ArrayList<>();
		eventList.forEach(e -> {
			if (e.getDiMOffStart() != 0) {
				Event ev = new Event();
				ev.title = "1";
				ev.start = String.valueOf(e.getDiMOffStart());
				ev.end = String.valueOf(e.getDiMOffEnd());
				
				events.add(ev);
			}
			if (e.getDiTOffStart() != 0) {
				Event ev = new Event();
				ev.title = "2";
				ev.start = String.valueOf(e.getDiTOffStart());
				ev.end = String.valueOf(e.getDiTOffEnd());
				
				events.add(ev);
			}
			if (e.getDiWOffStart() != 0) {
				Event ev = new Event();
				ev.title = "3";
				ev.start = String.valueOf(e.getDiWOffStart());
				ev.end = String.valueOf(e.getDiWOffEnd());
				
				events.add(ev);
			}
			if (e.getDiROffStart() != 0) {
				Event ev = new Event();
				ev.title = "4";
				ev.start = String.valueOf(e.getDiROffStart());
				ev.end = String.valueOf(e.getDiROffEnd());
				
				events.add(ev);
			}
			if (e.getDiFOffStart() != 0) {
				Event ev = new Event();
				ev.title = "5";
				ev.start = String.valueOf(e.getDiFOffStart());
				ev.end = String.valueOf(e.getDiFOffEnd());
				
				events.add(ev);
			}
			if (e.getDiSatOffStart() != 0) {
				Event ev = new Event();
				ev.title = "6";
				ev.start = String.valueOf(e.getDiSatOffStart());
				ev.end = String.valueOf(e.getDiSatOffEnd());
				
				events.add(ev);
			}
			if (e.getDiSunOffStart() != 0) {
				Event ev = new Event();
				ev.title = "0";
				ev.start = String.valueOf(e.getDiSunOffStart());
				ev.end = String.valueOf(e.getDiSunOffEnd());
				
				events.add(ev);
			}
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		if (events.size() > 0) {
			return new ResponseEntity<String>(new JSONSerializer().include("title","end","start").exclude("*").serialize(events), headers, HttpStatus.OK);
		}
	    return new ResponseEntity<String>(null, headers, HttpStatus.OK);
	}
	
	public List<String> getTeachers() {
		List<String> list = new ArrayList<>();
		dtTeacherRepository.findAll().forEach(e -> list.add(e.getEmail()));
		return list;
	}
}
