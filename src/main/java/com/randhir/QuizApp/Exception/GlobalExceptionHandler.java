package com.randhir.QuizApp.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	//Validation Exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> validationException(MethodArgumentNotValidException ex){
		Map<String,String> map= new HashMap<>();
		List<ObjectError> list= ex.getBindingResult().getAllErrors();
		for(ObjectError err:list) {
			String message=err.getDefaultMessage();
			String field= ((FieldError)err).getField();
			map.put(field,message);
		
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_GATEWAY);
	}
	
	

}
