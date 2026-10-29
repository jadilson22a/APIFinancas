package com.github.jadilson22a.APIFinanceira.exceptions;

public class FormatoException extends RuntimeException{

	public FormatoException(String message) {
		super(message);
	}

	public FormatoException() {
		super("Formato incorreto!");
	}

	
}
