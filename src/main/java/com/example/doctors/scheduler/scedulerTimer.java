package com.example.doctors.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.doctors.entity.Doctors;
import com.example.doctors.repo.doctorsRepo;
import com.example.doctors.service.doctorsService;

@EnableScheduling
@Configuration
public class scedulerTimer {
	
	@Autowired
	doctorsService dservice;
	doctorsRepo drepo;
	
	@Scheduled(cron = "0 1 0 * * *")
	public void freeDoc() {
		//Doctors doc = new Doctors();
		List<Doctors> dlist = drepo.findAll();
		for(Doctors i : dlist) {
			if(i.getStatus().equalsIgnoreCase("Booked")) {
				i.setStatus("Avaialable");
				System.out.print("Done");
			}
		}
		
			
		
	}

}
