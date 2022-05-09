package com.example.doctors.Exeptions;



import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MainExceptionHandler  extends ResponseEntityExceptionHandler{


		
		@ExceptionHandler(FieldRequiredException.class)
		public ResponseEntity<Object> fieldRequiredHandler (FieldRequiredException ex){
			
			String msg = "Input Fields cant be empty";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<Object> NoSuchElementException (NoSuchElementException ex){
			
			String msg = "Doctor Not found with This Id";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(DuplicateIdException.class)
		public ResponseEntity<Object> DuplicateIdException (DuplicateIdException ex){
			
			String msg = "New Users ID must Be Unique (  Another Doctor is Already Avialabe with this ID)";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(DoctorAlredyAppointedException.class)
		public ResponseEntity<Object> alredyAppointedHandler (DoctorAlredyAppointedException ex){
			
			String msg = "Doctor is Alredy Appointed";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(putUpdateException.class)
		public ResponseEntity<Object> putUpdateException (putUpdateException ex){
			
			String msg = "Doctor is Booked you cant changed to Available";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(FnamefiledMissingExeption.class)
		public ResponseEntity<Object> filedMissing1 (FnamefiledMissingExeption ex){
			
			String msg = "First Name Fileds is missing , All Fields Are Required.";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(LnamefiledMissingExeption.class)
		public ResponseEntity<Object> filedMissing2 (LnamefiledMissingExeption ex){
			
			String msg = "Last Name Filed is missing , All Fields Are Required.";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(StatusFieldMissingException.class)
		public ResponseEntity<Object> filedMissing3 (StatusFieldMissingException ex){
			
			String msg = "Status Filed is missing , All Fields Are Required.";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(SpecializationFieldfiledMissingExeption.class)
		public ResponseEntity<Object> filedMissing (SpecializationFieldfiledMissingExeption ex){
			
			String msg = "Specialization Filed is missing , All Fields Are Required.";
			
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(IdfiledMissingExeption.class)
		public ResponseEntity<Object> filedMissing4 (IdfiledMissingExeption ex){
			
			String msg = "ID field Filed is missing , All Fields Are Required.";
		
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		
		

}
