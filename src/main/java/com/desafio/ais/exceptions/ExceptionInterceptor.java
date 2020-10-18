package com.desafio.ais.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler{


	  @ExceptionHandler(ErroNegocioalException.class)
	  public final ResponseEntity<Object> handleAllExceptions(ErroNegocioalException ex) {
		  ErroNegocioalException exceptionResponse =
	        new ErroNegocioalException(ex.getMessage(), ex.getCause().toString());
	    return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
