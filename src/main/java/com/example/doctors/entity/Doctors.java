package com.example.doctors.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "doctorsWithMilliseconds")
public class Doctors {

	@Id
	private int id;
	@Column(name = "Fname")
	private String firstName;
	@Column(name = "Lname")
	private String secondName;
	private String specialization;
	private String status ;
	@Column(name="Local_Time")
	private long time;

	public Doctors() {
	}




	public Doctors(int id, String firstName, String secondName, String specialization, String status, long time) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.specialization = specialization;
		this.status = status;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String isBooked) {
		this.status = isBooked;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long start_time) {
		this.time = start_time;
	}
	
	

}
