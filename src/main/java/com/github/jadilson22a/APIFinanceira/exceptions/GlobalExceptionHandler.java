package com.github.jadilson22a.APIFinanceira.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NullObjectException.class)
	public ResponseEntity<ErroGenericoResposta> nullObject(NullObjectException exception){
		ErroGenericoResposta resposta = new ErroGenericoResposta(
				HttpStatus.NOT_FOUND,
				exception.getMessage());
		
		return new ResponseEntity<>(resposta,resposta.status());
	}
	
	@ExceptionHandler(ObjectExistsException.class)
	public ResponseEntity<ErroGenericoResposta> nullObject(ObjectExistsException exception){
		ErroGenericoResposta resposta = new ErroGenericoResposta(
				HttpStatus.CONFLICT,
				exception.getMessage());
		
		return new ResponseEntity<>(resposta,resposta.status());
	}
}
