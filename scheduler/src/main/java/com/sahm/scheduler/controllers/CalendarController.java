package com.sahm.scheduler.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
	
import com.sahm.scheduler.model.entity.DtLesson;
import com.sahm.scheduler.model.entity.DtLessonTime;
import com.sahm.scheduler.model.entity.Event;
import com.sahm.scheduler.model.repository.DtLessonRepository;
import com.sahm.scheduler.model.repository.DtLessonTimeRepository;

import flexjson.JSONSerializer;

@Controller
public class CalendarController extends HttpServlet {
private static final long serialVersionUID = 1L;

	@Autowired
	DtLessonRepository dtLessonRepository;
	
	@Autowired
	DtLessonTimeRepository dtLessonTimeRepository;

	@RequestMapping(value="/calendar")
	public String hello(Model model, HttpServletRequest request) {
		
		
		//getLessons(email, accountType);
		
		return "calendar";
	}
	
	
	@RequestMapping(value="/populate", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public ResponseEntity<String> getCalendarEvents(HttpServletRequest request){
		String email = (String) request.getSession().getAttribute("userEmail");
		int accountType = (int) request.getSession().getAttribute("AccountType");
		
		List<Event> eventList = new ArrayList<>();
		if (accountType == 2) { eventList = getTeacherLessons(email); }
		//else if (accountType == 3) { eventList = getParentLessons(email); }
		//else { eventList = getLessons(email); }
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		if (eventList.size() > 0) {
			return new ResponseEntity<String>(new JSONSerializer().include("id","title","end","start").exclude("*").serialize(eventList), headers, HttpStatus.OK);
		}
	    return new ResponseEntity<String>(null, headers, HttpStatus.OK);
	}
	
	
	
	// All of these are methods to grab specific lists of LessonTime objects fromt he DB 
	public List<Event> getTeacherLessons(String email){
		List<Integer> eventIDs = new ArrayList<>();
		dtLessonRepository.findByDsteacheremail(email).forEach(e -> eventIDs.add(e.getId()));
		
		List<DtLessonTime> eventList = new ArrayList<>();
		eventIDs.forEach(e -> eventList.addAll(dtLessonTimeRepository.findByDilessonid(e)));
		
		int id = 1;
		List<Event> events = new ArrayList<>();
		eventList.forEach(e -> {
			Event temp = new Event();
			temp.id = id;
			temp.title = e.getDsParentEmail();
			temp.start = e.getStartTimeAsString();
			temp.end = e.getEndTimeAsString();
			
			events.add(temp);
		});
		
		return events;
	}
	
	public List<DtLessonTime> getParentLessons(String email) {
		List<Integer> eventIDs = new ArrayList<>();
		dtLessonRepository.findByDsparentemail(email).forEach(e -> eventIDs.add(e.getId()));
		
		List<DtLessonTime> eventList = new ArrayList<>();
		eventIDs.forEach(e -> eventList.addAll(dtLessonTimeRepository.findByDilessonid(e)));
		
		return eventList;
	}
	
	public List<DtLessonTime> getLessons(String email) {
		
		List<DtLessonTime> eventList = new ArrayList<>();
		
		if (email == "admin@isp.net") {
			eventList.addAll(dtLessonTimeRepository.findAll());
		}
		
		return eventList;
	}	
}
