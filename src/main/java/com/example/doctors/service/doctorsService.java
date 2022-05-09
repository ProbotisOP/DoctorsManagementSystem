package com.example.doctors.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.doctors.Exeptions.DuplicateIdException;
import com.example.doctors.Exeptions.FieldRequiredException;
import com.example.doctors.entity.Doctors;
import com.example.doctors.repo.doctorsRepo;

@Service
public class doctorsService {

	@Autowired
	doctorsRepo drepo;

	public void addDoc(Doctors doctor) throws FieldRequiredException {

		List<Doctors> dlist = new ArrayList<Doctors>();
		for (Doctors doc : dlist) {
			if (doc.getId() == doctor.getId())
				throw new DuplicateIdException("Doctor Is Alredy Present with this ID");
		}

		if (doctor.getFirstName().isEmpty() || doctor.getFirstName().length() == 0) {
			throw new FieldRequiredException("Input fields are misising");
		}

		drepo.save(doctor);

		// throw new DuplicateIdException("Doctor Is Alredy Present with this ID");
	}

	public void modifyDoc(Doctors doctor) {
		
		drepo.save(doctor);
	}

	public void deleteDoctor(int id) {
		drepo.deleteById(id);
	}

	public List<Doctors> getAllDoctors() {
		return drepo.findAll();

	}

	public Doctors bookDoctor(int id) {

		return drepo.findById(id).get();
	}

	public Doctors getDoctor(int id) {

		return drepo.findById(id).get();
	}

	@Scheduled(initialDelay = 1000L, fixedDelay = 1000L)
	public void freeDoctor() {
		
		List<Doctors> dlist = drepo.findAll();
	
		for (Doctors doc : dlist) {
			
			if(doc.getStatus().equals("Booked")) {
				long end_time = System.currentTimeMillis();
				long difference = end_time- doc.getTime();
				if(difference >= 60000 ) {
					doc.setStatus("Available");
					doc.setTime(end_time);
					drepo.save(doc);
				}
				//System.out.println("Done");
			}
		}
	

	}
}
