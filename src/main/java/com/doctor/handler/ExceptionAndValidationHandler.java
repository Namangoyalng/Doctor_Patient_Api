package com.doctor.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionAndValidationHandler extends ResponseEntityExceptionHandler {
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult br = ex.getBindingResult();
		List<ObjectError> errors = br.getAllErrors();
		List<String> list = new ArrayList<>();
		ResponseError responseError = new ResponseError("Validation failed", list);
		for (ObjectError error : errors) {
			list.add(error.getDefaultMessage());
		}
		System.out.println("Handler called");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
	}

	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<Object> handleDoctorNotFoundEXception(DoctorNotFoundException ex) {
		List<String> list = new ArrayList<String>();
		list.add(ex.getMessage());
		ResponseError error = new ResponseError("Doctor not found exception", list);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(NoDocFoundAtLocationException.class)
	public ResponseEntity<Object> handleNoDocFoundAtLocation(NoDocFoundAtLocationException ex) {
		List<String> list = new ArrayList<String>();
		list.add(ex.getMessage());
		ResponseError error = new ResponseError("Doctor not found exception", list);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(NoDocFoundSymptomException.class)
	public ResponseEntity<Object> handleNoDocFoundSymptomException(NoDocFoundSymptomException ex) {
		List<String> list = new ArrayList<String>();
		list.add(ex.getMessage());
		ResponseError error = new ResponseError("Doctor not found exception", list);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object> handlePatienNotFoundException(PatientNotFoundException ex) {
		List<String> list = new ArrayList<String>();
		list.add(ex.getMessage());
		ResponseError error = new ResponseError("Patient not found exception", list);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
