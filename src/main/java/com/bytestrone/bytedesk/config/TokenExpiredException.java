package com.bytestrone.bytedesk.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import io.jsonwebtoken.ExpiredJwtException;

@ControllerAdvice
public class TokenExpiredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

@ExceptionHandler(value= {ExpiredJwtException.class})
	public ResponseEntity<Object> handleTokenExpiredException(){
		return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
	}

}
