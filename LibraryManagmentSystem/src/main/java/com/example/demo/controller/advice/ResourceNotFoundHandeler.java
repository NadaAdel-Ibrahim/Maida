package com.example.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.service.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceNotFoundHandeler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handeler (ResourceNotFoundException  ex){
		ErrorResponse er = new ErrorResponse();
		er.setCode(-1);
		er.setMessage(ex.getMessage());
		er.setDetails("More Details");
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(er);

	}

}
