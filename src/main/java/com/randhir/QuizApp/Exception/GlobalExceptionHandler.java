package com.randhir.QuizApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice     // this class is responsible to handle exception of whole project
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)  //handles exceptions argument: Name of class whose exception has to be handled
	public ResponseEntity<ApiResponse> badRequestException(BadRequestException ex){
		ApiResponse resp= new ApiResponse();
		resp.setMessage(ex.getMessage());
		resp.setStatus(HttpStatus.BAD_REQUEST);
		resp.setSuccess(false);
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SizeException.class)
	public ResponseEntity<ApiResponse> sizeException(SizeException es){
		ApiResponse resp= new ApiResponse();
		resp.setMessage(es.getMessage());
		resp.setSuccess(false);
		resp.setStatus(HttpStatus.BAD_GATEWAY);
		return new ResponseEntity<> (resp,HttpStatus.BAD_GATEWAY);
	}
	
	
	

}
