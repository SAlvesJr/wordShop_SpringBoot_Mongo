package com.SAlvesjr.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.SAlvesjr.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExcceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFund(ObjectNotFoundException e , HttpServletRequest req){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError erro = new StandarError(System.currentTimeMillis(), status.value(), "não encontrado", e.getMessage(), req.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
	}
}
