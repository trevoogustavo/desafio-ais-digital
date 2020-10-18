package com.desafio.ais.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler{


	  @ExceptionHandler(value = { ErroNegocioalException.class})
	  protected ResponseEntity<Object> handleExceptions(ErroNegocioalException ex, WebRequest request) {
		//ApiError erro = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		  String bodyResponse = ex.getMessage();
//		  ErroNegocioalException exceptionResponse =
//	        new ErroNegocioalException(ex.getMessage(), ex.getCause().toString());
		  
	    return new ResponseEntity<Object>( ex.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
