package com.example.doctors.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctors.entity.Doctors;

public interface doctorsRepo extends JpaRepository<Doctors, Integer>{

}
