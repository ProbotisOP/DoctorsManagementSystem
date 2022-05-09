package com.example.doctors.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.doctors.Exeptions.DoctorAlredyAppointedException;
import com.example.doctors.Exeptions.DuplicateIdException;
import com.example.doctors.Exeptions.FnamefiledMissingExeption;
import com.example.doctors.Exeptions.LnamefiledMissingExeption;
import com.example.doctors.Exeptions.SpecializationFieldfiledMissingExeption;
import com.example.doctors.Exeptions.StatusFieldMissingException;
import com.example.doctors.Exeptions.filedMissingExeption;
import com.example.doctors.Exeptions.putUpdateException;
import com.example.doctors.entity.Doctors;
import com.example.doctors.service.doctorsService;

@Controller

public class MainController {

	@Autowired
	doctorsService dservice;
	
	@GetMapping("/")
	public String Home() {
		return "home";
	}
	
	@GetMapping("/team")
	public String Team() {
		return "team";
	}
	
	@PostMapping("/showdocbyid")
	public String showdocbyID(@RequestParam("docid") String Docid , Model model) {
		
		System.out.println(Docid);
		
		int DoctintID = Integer.parseInt(Docid);
		model.addAttribute("doctorbyid", dservice.getDoctor(DoctintID));
		
		return "showdocbyid";
	}
	
	@PostMapping("/docbyid")
	public String docbyid(@PathVariable int id , Model model) {
		
		model.addAttribute("doctor", dservice.getDoctor(id));
		return "showdocbyid";
		
	}
	@GetMapping("/showDoc")
	public String showDoc(Model model) {
		
		model.addAttribute("doctor", dservice.getAllDoctors());
		
		return "doctors";
		
		
	}

	@GetMapping("/all")
	public ResponseEntity<List<Doctors>> getAllDoctors() {
		
		List<Doctors> dlist = dservice.getAllDoctors();
		for (Doctors doc : dlist) 
			{
			long time = System.currentTimeMillis();
			doc.setTime(time);
		}

		return new ResponseEntity<List<Doctors>>(dservice.getAllDoctors(), HttpStatus.OK);

	}

//	@GetMapping("/appoint/{id}")
//	public ResponseEntity<String> bookDoctor(@PathVariable("id") int id) throws NoSuchElementException {
//		Doctors doc = dservice.getDoctor(id);
//
//		if (doc.getStatus().equalsIgnoreCase("Booked")) {
//			throw new DoctorAlredyAppointedException("");
//
//		}
//
//		LocalTime lt = LocalTime.now();
//
//		doc.setStatus("Booked");
//		doc.setTime(lt);
//		dservice.modifyDoc(doc);
//	
//
//		return new ResponseEntity<String>("Doctor is Appointed for next 2 Minutes", HttpStatus.OK);
//
//	}
	
	@GetMapping("/appoint/{id}/{minute}")
	public ResponseEntity<String> bookDoctor(@PathVariable("id") int id ,@PathVariable("minute") long minute) throws NoSuchElementException {
		Doctors doc = dservice.getDoctor(id);

		if (doc.getStatus().equalsIgnoreCase("Booked")) {
			throw new DoctorAlredyAppointedException("");

		}

		//LocalTime lt = LocalTime.now().plusMinutes(minute-1);
		long start_time = System.currentTimeMillis();
		
		long milliseconds = minute * 60000 - 60000;

		doc.setStatus("Booked");
		doc.setTime(start_time + milliseconds );
		dservice.modifyDoc(doc);
	

		return new ResponseEntity<String>("Doctor is Appointed for next "+minute+" Minutes", HttpStatus.OK);

	}

//	@GetMapping("/release/{id}")
//	public ResponseEntity<String> freeDoctor(@PathVariable("id") int id) throws NoSuchElementException {
//		Doctors doc = dservice.getDoctor(id);
//		
//		LocalTime lt = LocalTime.now();
//		
//		int diff = lt.getMinute() - doc.getTime().getMinute();
//		
//		if( diff >= 2) {
//		doc.setStatus("Avaialble");
//		dservice.modifyDoc(doc);
//		return new ResponseEntity<String>("DOCTOR IS AVAILABLE NOW ", HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<String>("PLEASE WAIT  UNTIL DOCTORS SHIFT ENDS", HttpStatus.BAD_REQUEST);
//
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctors> getDoctor(@PathVariable("id") int id) throws NoSuchElementException {
		// Doctors doc = dservice.getDoctor(id);

		return new ResponseEntity<Doctors>(dservice.getDoctor(id), HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Doctors> addDoc(@RequestBody Doctors doctor) {

		List<Doctors> dlist = dservice.getAllDoctors();
		for (Doctors doc : dlist) {
			if (doc.getId() == doctor.getId()) {
				throw new DuplicateIdException("Doctor Is Alredy Present with this ID");
			}

			if (doctor.getFirstName() == null) {
				throw new FnamefiledMissingExeption("");
			}
			if (doctor.getSecondName() == null) {
				throw new LnamefiledMissingExeption("");
			}
			if (doctor.getSpecialization() == null) {
				throw new SpecializationFieldfiledMissingExeption("");
			}
			if (doctor.getStatus() == null) {
				throw new StatusFieldMissingException("");
			}
//			if (doctor.getTime() == null) {
//				throw new filedMissingExeption("");
//			}

		}

		dservice.addDoc(doctor);

		return new ResponseEntity<Doctors>(doctor, HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Doctors> deleteDoctor(@PathVariable("id") int id) {

		Doctors doc = dservice.getDoctor(id);
		if (doc.getId() == id) {
			dservice.deleteDoctor(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<Doctors>(HttpStatus.BAD_REQUEST);

	}

	@PutMapping
	public ResponseEntity<Doctors> modifyDoc(@RequestBody Doctors doctor) {

		Doctors doc1 = dservice.getDoctor(doctor.getId());
		System.out.println(doc1);
		// System.out.print(doctor.getId());
		if (doc1.getStatus().equalsIgnoreCase("Booked") && doctor.getStatus().equalsIgnoreCase("Available"))
			throw new putUpdateException("");

		dservice.modifyDoc(doctor);

		return new ResponseEntity<Doctors>(doctor, HttpStatus.CREATED);

	}

}
