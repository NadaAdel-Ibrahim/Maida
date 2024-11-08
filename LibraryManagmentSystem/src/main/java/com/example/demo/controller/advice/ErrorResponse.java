package com.example.demo.controller.advice;

import lombok.Data;

@Data
public class ErrorResponse {
	
	int code ; 
	String message ;
	String details ;
	
	
	public void setDetails(String details) {
		this.details=details;	
	}


	public void setMessage(String message) {
		this.message=message;
	}


	public String getMessage(String message) {
		return message;	
	}


	public void setCode(int code) {
		this.code=code;	
	}
	
	

}
