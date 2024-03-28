package com.soul.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResorceNotFoundException extends RuntimeException{
	
	public ResorceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
