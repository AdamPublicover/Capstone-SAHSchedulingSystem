package com.sahm.scheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sahm.scheduler.model.entity.DtInstrument;
import com.sahm.scheduler.model.entity.DtLesson;
import com.sahm.scheduler.model.entity.DtParent;
import com.sahm.scheduler.model.entity.DtPassword;
import com.sahm.scheduler.model.entity.DtTeacher;
import com.sahm.scheduler.model.entity.DtTeacherAvailability;
import com.sahm.scheduler.model.repository.DtInstrumentRepository;
import com.sahm.scheduler.model.repository.DtLessonRepository;
import com.sahm.scheduler.model.repository.DtParentRepository;
import com.sahm.scheduler.model.repository.DtPasswordRepository;
import com.sahm.scheduler.model.repository.DtTeacherAvailabilityRepository;
import com.sahm.scheduler.model.repository.DtTeacherRepository;

@Controller
@RequestMapping(path="/CreateParent")
public class DtParentCreateController {
	
	@Autowired
	private DtParentRepository parentRepository;
	
	@Autowired
	private DtTeacherRepository teacherRepository;
	
	@Autowired
	private DtInstrumentRepository instrumentRepository;
	
	@Autowired
	private DtLessonRepository lessonRepository;
	
	@Autowired
	private DtTeacherAvailabilityRepository teacherAvailabilityRepository;
	
	@Autowired
	private DtPasswordRepository passwordRepository;
	
	
	@PostMapping(path="/addDtParent")
	public @ResponseBody String addNewUser () {
		
		// Parent insert test
		DtParent parent = new DtParent();
		parent.setEmail("example@hotmail.com");
		parent.setFirstName("John");
		parent.setLastName("Doe");
		parent.setPhoneNum("416-955-2534");
		parent.setAddress("460 Lawrence Ave W.");
		
		parentRepository.save(parent);
		
		
		
		// Teacher insert test
		DtTeacher teacher = new DtTeacher();
		teacher.setEmail("adampub@gmail.com");
		teacher.setFName("Adam");
		teacher.setLName("Publicover");
		
		teacherRepository.save(teacher);
		
		
		/* Instrument insert test
		DtInstrument instrument = new DtInstrument();
		instrument.setName("Clarinet");
		instrument.setRequiredByTeacher(1);
		
		instrumentRepository.save(instrument);
		*/
		
		// Lesson insert test
		DtLesson lesson = new DtLesson();
		lesson.setDiInstrumentId(1);
		lesson.setDsTeacherEmail("adampub@gmail.com");
		lesson.setDsParentEmail("example@hotmail.com");
		
		lessonRepository.save(lesson);
		
		
		// Teacher Avail test
		DtTeacherAvailability teachAvail = new DtTeacherAvailability();
		teachAvail.setDsTeacherEmail("adampub@gmail.com");
		//teachAvail.setDiMOffStart(12);
		//teachAvail.setDiMOffEnd(14);
		teachAvail.setDiMOffStart(19);
		teachAvail.setDiMOffEnd(20);	
		//teachAvail.setDiWOffStart(8);
		//teachAvail.setDiWOffEnd(14);
		//teachAvail.setDiROffStart(9);
		//teachAvail.setDiROffEnd(17);
		
		// teacherAvailabilityRepository.save(teachAvail);
		
		
		// Password Insert Test
		DtPassword dtPassword = new DtPassword();
		dtPassword.setDsEmail("adampub@gmail.com");
		dtPassword.setDsPassword("abc1234");
		dtPassword.setDiAccountType(2);
		
		passwordRepository.save(dtPassword);
		
		
		
		return "Saved";
		
	}
	
	@GetMapping(path="/getAllParents")
	public @ResponseBody Iterable<DtParent> getAllDtParents() {
		return parentRepository.findAll();
	}
}
