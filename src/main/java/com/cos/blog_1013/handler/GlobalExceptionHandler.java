package com.cos.blog_1013.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog_1013.dto.ResponseDTO;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler{
	
	/*
	 * @ExceptionHandler(value = IllegalArgumentException.class) public String
	 * handleArgumentException(IllegalArgumentException e) { return
	 * "<h1>"+e.getMessage()+" 일리걸 익셉션 </h1>"; }
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseDTO<String> handleArgumentException(Exception e){
		return new ResponseDTO<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}

}
