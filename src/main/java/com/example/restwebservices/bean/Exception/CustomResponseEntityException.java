package com.example.restwebservices.bean.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * To handle all the user Controller
 * @author ezaksch
 *
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		
		ExceptionResponse exResponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserResourceNotFoundException.class)
	public final ResponseEntity<Object> handleAllException(UserResourceNotFoundException ex, WebRequest request){
		
		ExceptionResponse exResponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exResponse=new ExceptionResponse(new Date(), ex.getBindingResult().getAllErrors().toString(), ex.getMessage().toString());

		return new ResponseEntity(exResponse,HttpStatus.NOT_ACCEPTABLE);
	}
}
