package com.github.jadilson22a.APIFinanceira.exceptions;

public class ObjectExistsException extends RuntimeException {

	public ObjectExistsException(String message) {
		super(message);
	}

	public ObjectExistsException() {
		super("Objeto existente!");
	}

	
}
