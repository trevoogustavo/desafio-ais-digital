package com.desafio.ais.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;

	   
	   private ApiError() {
	       timestamp = LocalDateTime.now();
	       message = this.message;
	       status = this.status;
	       debugMessage= this.debugMessage;
	   }
	   
	   ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	   }
	   
	   ApiError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Erro Inexperado";
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	   
	   ApiError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }
}
