package com.sahm.scheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sahm.scheduler.model.entity.DtInstrument;
import com.sahm.scheduler.model.entity.DtLessonTime;
import com.sahm.scheduler.model.entity.EventInfo;
import com.sahm.scheduler.model.repository.DtInstrumentRepository;
import com.sahm.scheduler.model.repository.DtLessonTimeRepository;

@Controller
public class EventInfoController {
	
	@Autowired
	DtLessonTimeRepository dtLessonTimeRepository;
	
	@Autowired
	DtInstrumentRepository dtInstrumentRepository;
	
	@RequestMapping(value="/eventinfo", method=RequestMethod.GET)
	public String eventInfoPage(Model model,
			@RequestParam("email") String email) {
		
		DtLessonTime dtLessonTime = dtLessonTimeRepository.findFirstByDsparentemail(email);
		DtInstrument dtInstrument = dtInstrumentRepository.findByInstrumentid(dtLessonTime.getDiInstrumentId());
		
		EventInfo ei = new EventInfo();
		ei.parent = dtLessonTime.getDsParentEmail();
		ei.teacher = dtLessonTime.getDsTeacherEmail();
		ei.instrument = dtInstrument.getName();
		ei.date = dtLessonTime.getStartTimeAsString();
		ei.length = String.valueOf(dtLessonTime.getDiLength());
		
		model.addAttribute("eventInfo", ei);
		
		return "eventinfo";
	}

}
