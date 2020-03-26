package com.sahm.scheduler.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import com.sahm.scheduler.model.entity.TTeacherPlaysInstrument;
import com.sahm.scheduler.model.repository.TTeacherPlaysInstrumentRepository;

@Controller
public class SelectInstrumentsController {
	
	@Autowired
	TTeacherPlaysInstrumentRepository tTeacherPlaysInstrumentRepository;
	
	@RequestMapping(value="/select_instruments_t")
	public String hello(Model model) {
		return "select_instruments_t";
	}
	
	
	@RequestMapping(value="/select_instruments_t/update_instruments", method=RequestMethod.POST)
	public String updateInstruments(Model model,
			HttpServletRequest request,
			@RequestParam(value = "guitar", required = false) String guitar,
			@RequestParam(value = "piano", required = false) String piano,
			@RequestParam(value = "ukulele", required = false) String ukulele,
			@RequestParam(value = "drums", required = false) String drums,
			@RequestParam(value = "mandolin", required = false) String mandolin,
			@RequestParam(value = "vocals", required = false) String vocals,
			@RequestParam(value = "trumpet", required = false) String trumpet,
			@RequestParam(value = "violin", required = false) String violin,
			@RequestParam(value = "bass", required = false) String bass
			) {
		
		String email = (String) request.getSession().getAttribute("userEmail");
		
		if (guitar != null) { createTeacherPlaysInstrumentRecord(1, email); }
		if (piano != null) { createTeacherPlaysInstrumentRecord(2, email); }
		if (ukulele != null) { createTeacherPlaysInstrumentRecord(3, email); }
		if (drums != null) { createTeacherPlaysInstrumentRecord(4, email); }
		if (mandolin != null) { createTeacherPlaysInstrumentRecord(5, email); }
		if (vocals != null) { createTeacherPlaysInstrumentRecord(6, email); }
		if (trumpet != null) { createTeacherPlaysInstrumentRecord(7, email); }
		if (violin != null) { createTeacherPlaysInstrumentRecord(8, email); }
		if (bass != null) { createTeacherPlaysInstrumentRecord(9, email); }
	
		
		return "calendar";
	}
	
	public void createTeacherPlaysInstrumentRecord(int instrumentId, String email){
		TTeacherPlaysInstrument record = new TTeacherPlaysInstrument();
		record.setDtInstrumentId(instrumentId);
		record.setDsTeacherEmail(email);
		
		tTeacherPlaysInstrumentRepository.save(record);
	}
	
}
