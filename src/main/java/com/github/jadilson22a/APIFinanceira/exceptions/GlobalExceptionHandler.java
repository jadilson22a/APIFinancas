package com.github.jadilson22a.APIFinanceira.exceptions;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NullObjectException.class)
	public ResponseEntity<ErroGenericoResposta> nullObject(NullObjectException exception){
		ErroGenericoResposta resposta = new ErroGenericoResposta(
				HttpStatus.NOT_FOUND,
				exception.getMessage());
		
		return new ResponseEntity<>(resposta,resposta.status());
	}
	
	@ExceptionHandler(ObjectExistsException.class)
	public ResponseEntity<ErroGenericoResposta> objectExists(ObjectExistsException exception){
		ErroGenericoResposta resposta = new ErroGenericoResposta(
				HttpStatus.CONFLICT,
				exception.getMessage());
		
		return new ResponseEntity<>(resposta,resposta.status());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<RespostaErroCampos> objectInvalid(
			MethodArgumentNotValidException exception) {
		List<CampoErro> camposErros = new ArrayList<>();
		
		for(FieldError x: exception.getFieldErrors()) {
			camposErros.add(new CampoErro(x.getField(), x.getDefaultMessage()));
		}
		
		RespostaErroCampos resposta = new RespostaErroCampos(
				HttpStatus.BAD_REQUEST, 
				"Erro de validacao!",
				camposErros);
		
		return new ResponseEntity<RespostaErroCampos>(resposta, resposta.status());
	}
	
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<ErroGenericoResposta> dataIncorreta(DateTimeParseException exception){
		ErroGenericoResposta resposta = new ErroGenericoResposta(
				HttpStatus.BAD_REQUEST,
				"A data esta com o formato incorreto, formato aceito: dd/MM/yyyy");
		
		return new ResponseEntity<>(resposta,resposta.status());
	}
}
