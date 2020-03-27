package com.sahm.scheduler.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

import com.sahm.scheduler.model.entity.DtInstrument;
import com.sahm.scheduler.model.entity.DtLesson;
import com.sahm.scheduler.model.entity.DtLessonTime;
import com.sahm.scheduler.model.entity.DtTeacher;
import com.sahm.scheduler.model.repository.DtInstrumentRepository;
import com.sahm.scheduler.model.repository.DtLessonRepository;
import com.sahm.scheduler.model.repository.DtLessonTimeRepository;
import com.sahm.scheduler.model.repository.DtTeacherRepository;

@Controller
public class CreateLessonController {
	
	@Autowired
	DtInstrumentRepository dtinstrumentRepository;
	
	@Autowired
	DtTeacherRepository dtteacherRepository;
	
	@Autowired
	DtLessonRepository dtLessonRepository;
	
	@Autowired
	DtLessonTimeRepository dtLessonTimeRepository;	
	
	@RequestMapping(value="/create_lesson")
	public String hello(Model model) {
		List<String> myInstruments = getInstruments();
		List<String> myTeachers = getTeachers();
		model.addAttribute("instruments", myInstruments);
		model.addAttribute("teachers", myTeachers);
		
		// Example of Implementation:
		// myInstruments.forEach(e -> System.out.println(e));
		// myTeachers.forEach(e -> System.out.println(e));

		
		return "create_lesson";
	}
	
	public List<String> getInstruments(){
		List<String> list = new ArrayList<>();
		dtinstrumentRepository.findAll().forEach(e -> list.add(e.getName()));
		
		return list;
	}
	
	
	public List<String> getTeachers() {
		List<String> list = new ArrayList<>();
		dtteacherRepository.findAll().forEach(e -> list.add(e.getEmail()));
		return list;
	}
	
	
	@RequestMapping(value="/create_lesson/submit", method=RequestMethod.POST)
	public String updateCalendar(Model model,
			HttpServletRequest request,
			@RequestParam(value="instruments", required=false) String instrument,
			@RequestParam(value="teachers", required=false) String teacher,
			@RequestParam(value="start", required=false) String startTime,
			@RequestParam(value="length", required=false) String length) {
		
		String userEmail = (String) request.getSession().getAttribute("userEmail");
		DtInstrument dtInstrument = dtinstrumentRepository.findByInstrument(instrument);
		DtTeacher dtTeacher = dtteacherRepository.findByDsEmail(teacher);
		
		DtLesson dtLesson = new DtLesson();
		dtLesson.setDsParentEmail(userEmail);
		dtLesson.setDiInstrumentId(dtInstrument.getId());
		dtLesson.setDsTeacherEmail(dtTeacher.getEmail());
		
		dtLessonRepository.save(dtLesson);
		
		//System.out.println(dtLesson.getId());
		/*
		DtLessonTime dtLessonTime = new DtLessonTime();
		dtLessonTime.setDiLessonId(dtLesson.getId());
		dtLessonTime.setDiLength(Integer.parseInt(length));
		dtLessonTime.setDdLessonDate(startTime);
		
		dtLessonTimeRepository.save(dtLessonTime);
		*/
		return "calendar";
	}
	
	// All of the below methods will be replaced.
	
	@RequestMapping(value="/updateJSON")
	public String updateCalendar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String start = request.getParameter("start");
		int minutes = Integer.valueOf(request.getParameter("duration"));
		

		System.out.println(start);
		System.out.println(endDate(start, minutes));
		
		addEvent(start,endDate(start,minutes),"Admin");
		
		response.sendRedirect("calendar");
		return "calendar";
	}
	
	public String endDate(String start, int duration) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime(sdf.parse(start));
		} catch (Exception e) { System.out.println(e); }
		
		cal.add(Calendar.MINUTE, duration );
		
		return sdf.format(cal.getTime());
	}
	
	public void addEvent(String start, String end, String title) {
		try {
			String contents = new Scanner(new File("src/main/resources/static/demo/demo.json")).useDelimiter("\\Z").next();
			contents = contents.substring(0, contents.length() - 1);
			
			String newJson = ",{\"id\":\"c\",\"title\":\"Lesson: " + title;
			newJson += "\",\"start\":\"" + start;
			newJson += "\",\"end\":\"" + end;
			newJson += "\",\"backgroundColor\":\"#FFB3A3\"}]";
			
			System.out.println(newJson);
			
			addToFile(contents + newJson);
			  
		} catch (Exception e) { System.out.println(e); }
	}
	
	public void addToFile(String newJson) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("src/main/resources/static/demo/demo.json"));
			os.write(newJson.getBytes(), 0, newJson.length());
		} catch (Exception e) {e.printStackTrace(); }
		finally { 
			try {
				os.close();
			} catch (Exception e) { e.printStackTrace(); }
		}
	}
}
