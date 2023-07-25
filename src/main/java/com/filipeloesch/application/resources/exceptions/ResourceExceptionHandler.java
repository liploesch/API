package com.filipeloesch.application.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.filipeloesch.application.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		List<String> list = new ArrayList<>();
		list.add(e.getMessage());
		StandardError err = new StandardError(Instant.now(), status.value(), error, list, request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		String error = "Bad request";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();
		List<String> list = new ArrayList<>();
		fieldErrorList.forEach(err -> list.add(err.getDefaultMessage()));
		StandardError ster = new StandardError(Instant.now(), status.value(), error, list, request.getRequestURI());
		return ResponseEntity.status(status).body(ster);
	}
}
